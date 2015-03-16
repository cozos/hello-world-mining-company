function initGoal()
	goal = {
		alpha = 1,
		s = 20,
		r = 50,
		x = 700,
		y = 500,
		F = function(px, py) 
			local dx = goal.x - px
			local dy = goal.y - py
			local dist  = math.sqrt(dx^2 + dy^2)
			local theta = math.atan2(dy, dx)
			if dist < goal.r then
				return{
				x = 0,
				y = 0
				}
			elseif goal.r <= dist and dist <= goal.s + goal.r then
				return{
				x = goal.alpha * (dist - goal.r) * math.cos(theta),
				y = goal.alpha * (dist - goal.r) * math.sin(theta)
				}
			elseif dist > goal.s + goal.r then
				return{
				x = goal.alpha * goal.s * math.cos(theta),
				y = goal.alpha * goal.s * math.sin(theta)
				}
			end
		    end
    	}
end

function initObstacle()
	obst = {
		alpha = 2, --scaling factor
		s = 20,
		r = 50,
		x = 450,
		y = 350,
		F = function(px, py) 
			local dx = obst.x - px
			local dy = obst.y - py
			local dist  = math.sqrt(dx^2 + dy^2)
			local theta = math.atan2(dy, dx)
			if (dist < obst.r) or (obst.r <= dist and dist <= obst.s + obst.r) then
				return{
				x = -obst.alpha * (obst.s -dist + obst.r) * math.cos(theta),
				y = -obst.alpha * (obst.s -dist + obst.r) * math.sin(theta)
				}
			elseif dist > obst.s + obst.r then
				return{
				x = 0,
				y = 0
				}
			end
		    end
    	}
end

function initRobot()
	robot = {
		x = 10,
		y = 10
	}
end

------------------------------------------------------------------------

function love.draw()
	-- let's draw our goal
	love.graphics.setColor(0,255,0,255)
	love.graphics.circle("fill", goal.x,goal.y, 15, 15)

	-- let's draw our obst
	love.graphics.setColor(255,255,0,255)
	love.graphics.circle("fill", obst.x, obst.y, 15, 15)

	-- let's draw our robot
	love.graphics.setColor(0,0,255,255)
	love.graphics.circle("fill", robot.x, robot.y, 15, 15)

	-- let's draw our vector field
	local rangex = 800
	local range = 600
	local skip = 15
	for i=0, rangex, skip do
		for j=0, range, skip do
			local gxy = goal.F(i,j)
			local oxy = obst.F(i,j)
			love.graphics.setColor(255,0,0,255)
			local fx = oxy.x + gxy.x + i
			local fy = oxy.y + gxy.y + j
			love.graphics.line(i, j, fx, fy)
			local diff = 6
			love.graphics.polygon("fill", 
				fx, fy, 
				fx-diff, fy, 
				fx, fy-diff) 
			--love.graphics.line(i, j, oxy.x + i, j + oxy.y )
		end
	end
end


function love.load()
	initGoal()
	initRobot()
	initObstacle()
end

function love.update(dt)
end
