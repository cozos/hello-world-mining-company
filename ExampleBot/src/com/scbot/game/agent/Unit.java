package com.scbot.game.agent;

import com.scbot.game.state.GameState;
import com.scbot.game.actions.Action;
import com.scbot.utils.dto.Position;

import java.util.Collection;

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
    public Collection<Action> getActions(GameState state) {
        return null;
    }
}
