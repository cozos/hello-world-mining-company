package com.scbot.game.agent;

import com.scbot.game.actions.IAction;
import com.scbot.game.state.GameState;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by User1 on 5/10/2015.
 */
public class ResourceManagerAgent extends HeirarchicalAgent{

    @Override
    public Collection<IAction> getActions(GameState state) {

        Collection<IUnit> idleWorkers = state.getIdleWorkers();
        Collection<IAction> actions = new ArrayList<>();

        for(IUnit unit : idleWorkers){
            Collection<IAction> unitActions = unit.getActions(state);
            for (IAction action : unitActions){
                state.occupyMineral(action.getTargetID());
            }
            actions.addAll(unitActions);
        }

        return actions;
    }
}
