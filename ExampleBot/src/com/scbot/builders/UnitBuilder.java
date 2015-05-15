package com.scbot.builders;

import com.scbot.game.agent.Unit;
import com.scbot.game.agent.Unit;

/**
 * Created by User1 on 5/4/2015.
 */
public class UnitBuilder {

    private Unit instance;

    public UnitBuilder buildAgent(bwapi.Unit unit) {
        instance = new Unit(unit);
        return this;
    }

    public Unit build(){
        return instance;
    }
}
