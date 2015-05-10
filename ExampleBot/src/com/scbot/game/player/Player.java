package com.scbot.game.player;

import com.scbot.game.Game;
import com.scbot.game.agent.IAgent;
import com.scbot.providers.AgentProvider;

import java.util.Collection;

/**
 * Created by User1 on 5/4/2015.
 */
public class Player implements IPlayer{

    private AgentProvider agentProvider;

    private Collection<IAgent> agents;

    public Player(AgentProvider agentProvider){
        this.agentProvider = agentProvider;
    }

    public void update(){
        this.agents = agentProvider.getCurrentPlayerAgents();
    }
}
