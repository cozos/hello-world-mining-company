package com.scbot.game.agent;

import com.scbot.game.state.GameState;
import com.scbot.game.actions.Action;

import java.util.Collection;

/**
 * Created by User1 on 5/9/2015.
 */
public interface IAgent {
    Collection<Action> getActions(GameState state);
}
