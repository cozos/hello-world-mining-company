package com.scbot.providers;

import com.scbot.game.agent.IUnit;

import java.util.Collection;

/**
 * Created by User1 on 5/4/2015.
 */
public interface IUnitProvider {
    Collection<IUnit> getAgents(int ID);
}
