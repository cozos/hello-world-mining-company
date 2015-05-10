package com.scbot.game.agent;

import com.scbot.game.state.GameState;
import com.scbot.utils.Action;
import com.scbot.utils.dto.Position;

import java.util.Collection;

/**
 * Created by User1 on 5/4/2015.
 */
public class Unit implements IUnit, IAgent {

    private Position position;

    public Unit(Position position){
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
