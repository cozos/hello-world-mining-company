package com.scbot.game.agent;

import com.scbot.game.actions.GatherAction;
import com.scbot.game.state.GameState;
import com.scbot.game.actions.Action;
import com.scbot.utils.dto.Position;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by User1 on 5/4/2015.
 */
public class Unit implements IUnit, IAgent {

    private int ID;

    private Position position;

    public Unit(int ID, Position position){
        this.ID = ID;
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public int getDistance(IUnit unit) {
        int newx = Math.abs(this.position.getX() - unit.getPosition().getX());
        int newy = Math.abs(this.position.getY() - unit.getPosition().getY());
        return (int)Math.sqrt(newx*newx + newy*newy);
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public Collection<Action> getActions(GameState state) {

        Collection<Action> actions = new ArrayList<>();
        Collection<IUnit> mineralFields = state.getMineralFields();

        IUnit closestMineral = null;

        for(IUnit mineral : mineralFields){
            if(closestMineral==null || this.getDistance(mineral) < this.getDistance(closestMineral)){
                closestMineral = mineral;
            }
        }

        if(closestMineral != null){
            actions.add(new GatherAction(this.getID(), closestMineral.getID()));
        }

        return actions;
    }
}
