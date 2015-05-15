package com.scbot.providers;

import com.scbot.game.agent.Unit;

import java.util.Collection;

/**
 * Created by User1 on 5/4/2015.
 */
public interface IUnitProvider {
    Collection<Unit> getAgents(bwapi.Player player);
}
