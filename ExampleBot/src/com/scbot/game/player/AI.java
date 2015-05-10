package com.scbot.game.player;

import com.scbot.game.agent.IAgent;
import com.scbot.game.state.GameState;
import com.scbot.providers.UnitProvider;
import com.scbot.game.actions.Action;

import java.util.Collection;
import java.util.List;

/**
 * Created by User1 on 5/4/2015.
 */
public class AI implements IPlayer, IAgent{

    private int playerID;

    // AI has multiple sub-AIs
    private List<IAgent> agents;

    public AI(int playerID, UnitProvider unitProvider, List<IAgent> agents){
        this.playerID = playerID;
        this.agents = agents;
    }

    public int getID(){
        return this.playerID;
    }

    public Collection<Action> getActions(GameState gameState){
        return null;
    }
}
