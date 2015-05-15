package com.scbot.game.agent;

import com.scbot.game.actions.GatherAction;
import com.scbot.game.state.GameState;
import com.scbot.game.actions.IAction;
import com.scbot.utils.dto.Position;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by User1 on 5/4/2015.
 */
public class Unit implements IAgent {

    public bwapi.Unit unit;

    public Unit(bwapi.Unit unit){
        this.unit = unit;
    }

    @Override
    public Collection<IAction> getActions(GameState state) {

        Collection<IAction> IActions = new ArrayList<>();
        Collection<bwapi.Unit> mineralFields = state.getMineralFields();

        bwapi.Unit closestMineral = null;

        for(bwapi.Unit mineral : mineralFields){
            if(closestMineral==null || this.unit.getDistance(mineral) < this.unit.getDistance(closestMineral)){
                closestMineral = mineral;
            }
        }

        if(closestMineral != null){
            IActions.add(new GatherAction(this.unit, closestMineral));
        }

        return IActions;
    }
}
