package com.scbot.game.player;

import com.scbot.game.agent.HeirarchicalAgent;

import java.util.Collection;

/**
 * Created by User1 on 5/4/2015.
 */
public class AI extends HeirarchicalAgent implements IPlayer{

    private int playerID;

    public AI(int playerID, Collection<HeirarchicalAgent> departments){
        super(departments);
        this.playerID = playerID;
    }

    public int getID(){
        return this.playerID;
    }
}
