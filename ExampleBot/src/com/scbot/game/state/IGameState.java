package com.scbot.game.state;

import com.scbot.game.agent.Agent;

import java.util.Collection;

/**
 * Created by User1 on 5/7/2015.
 */
public interface IGameState {
    Collection<Agent> getPlayerUnits();
    Collection<Agent> getEnemyUnits();
}
