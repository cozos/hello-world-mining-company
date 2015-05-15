package com.scbot.game.player;

import com.scbot.game.agent.HeirarchicalAgent;

import java.util.Collection;

/**
 * Created by User1 on 5/4/2015.
 */
public class AI extends HeirarchicalAgent {

    public bwapi.Player player;

    public AI(bwapi.Player player, Collection<HeirarchicalAgent> departments){
        super(departments);
        this.player = player;
    }
}
