package com.scbot.providers;

import com.scbot.builders.AgentBuilder;
import com.scbot.game.Game;
import com.scbot.game.agent.Agent;
import com.scbot.game.agent.IAgent;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by User1 on 5/4/2015.
 */
public class AgentProvider implements IAgentProvider {

    private Game game;

    public AgentProvider(Game game){
        this.game = game;
    }

    public Collection<IAgent> getCurrentPlayerAgents() {
        AgentBuilder builder = new AgentBuilder();
        return game.getPlayerUnits()
                .stream()
                .map(unit -> builder.buildAgent(unit).build())
                .collect(Collectors.toList());
    }

    public Collection<IAgent> getCurrentPlayerEnemyAgents() {
        AgentBuilder builder = new AgentBuilder();
        return game.getEnemyUnits()
                .stream()
                .map(unit -> builder.buildAgent(unit).build())
                .collect(Collectors.toList());
    }
}
