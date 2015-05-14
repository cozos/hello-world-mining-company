package com.scbot.game.player;

import com.scbot.game.agent.IAgent;
import com.scbot.game.agent.IUnit;
import com.scbot.game.state.GameState;
import com.scbot.game.actions.IAction;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by User1 on 5/4/2015.
 */
public class AI implements IPlayer, IAgent{

    private int playerID;

    private Collection<IAgent> agents;

    public AI(int playerID, Collection<IAgent> agents){
        this.agents = agents;
        this.playerID = playerID;
    }

    public int getID(){
        return this.playerID;
    }

    public Collection<IAction> getActions(GameState gameState){
        Collection<IAction> actions = new ArrayList<>();
        agents.forEach(agent -> actions.addAll(agent.getActions(gameState)));
        return actions;
    }
}
