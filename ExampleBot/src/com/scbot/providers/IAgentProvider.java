package com.scbot.providers;

import com.scbot.game.agent.Agent;
import com.scbot.game.agent.IAgent;

import java.util.Collection;

/**
 * Created by User1 on 5/4/2015.
 */
public interface IAgentProvider {
    Collection<IAgent> getCurrentPlayerEnemyAgents();
    Collection<IAgent> getCurrentPlayerAgents();
}
