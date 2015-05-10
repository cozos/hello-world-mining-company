package com.scbot.game.agent;

import com.scbot.utils.dto.Position;

/**
 * Created by User1 on 5/4/2015.
 */
public class Agent implements IAgent{

    private Position position;

    private boolean isIdle = false;

    private boolean isWorker = false;

    public Agent(Position position){
        this.position = position;
    }

    public void setIsIdle(boolean isIdle) {
        this.isIdle = isIdle;
    }

    public void setIsWorker(boolean isWorker) {
        this.isWorker = isWorker;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public boolean isIdle() {
        return this.isIdle;
    }

    @Override
    public boolean isWorker() {
        return this.isWorker;
    }

}
