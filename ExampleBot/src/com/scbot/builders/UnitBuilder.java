package com.scbot.builders;

import com.scbot.game.agent.Unit;
import com.scbot.game.agent.IUnit;
import com.scbot.utils.translators.PositionTranslator;

/**
 * Created by User1 on 5/4/2015.
 */
public class UnitBuilder {

    private IUnit instance;

    public UnitBuilder buildAgent(bwapi.Unit unit) {
        instance = new Unit(PositionTranslator.translatePosition(unit.getPosition()));
        return this;
    }

    public IUnit build(){
        return instance;
    }
}
