package com.scbot.game.player;

import com.scbot.game.actions.Action;
import com.scbot.game.state.GameState;

import java.util.Collection;

/**
 * Created by User1 on 5/4/2015.
 */
public interface IPlayer {
    int getID();
    Collection<Action> getActions(GameState gameState);
}
