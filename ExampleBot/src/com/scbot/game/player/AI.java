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

    private int ID;

    // AI has multiple sub-AIs
    private List<IAgent> agents;

    public AI(int ID, UnitProvider unitProvider, List<IAgent> agents){
        this.ID = ID;
        this.agents = agents;
    }

    public int getID(){
        return this.ID;
    }

    public Collection<Action> getActions(GameState gameState){
        return null;
    }
}
