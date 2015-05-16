package com.scbot.game.agent;

import bwapi.UnitType;
import com.scbot.game.Game;
import com.scbot.game.actions.IAction;
import com.scbot.game.actions.TrainAction;
import com.scbot.game.state.GameState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by User1 on 5/10/2015.
 */
public class ResourceManagerAgent extends HeirarchicalAgent{

    public Collection<IAction> getCommandCenterSCVTrainingActions(GameState state){
        bwapi.Unit commCenter = state.getCommandCenter();
        if(commCenter != null && !commCenter.isTraining()){
            return Arrays.asList(new TrainAction(commCenter, UnitType.Terran_SCV));
        }
        return new ArrayList<>();
    }

    public Collection<IAction> getSCVMiningActions(GameState state){

        Collection<Unit> idleWorkers = state.getIdleWorkers();
        Collection<IAction> actions = new ArrayList<>();

        for(Unit unit : idleWorkers){
            Collection<IAction> unitActions = unit.getActions(state);
            for (IAction action : unitActions){
                state.occupyMineral(action.getTarget());
            }
            actions.addAll(unitActions);
        }

        return actions;
    }

    @Override
    public Collection<IAction> getActions(GameState state) {
        Collection<IAction> allActions = new ArrayList<>();
        allActions.addAll(this.getSCVMiningActions(state));
        allActions.addAll(this.getCommandCenterSCVTrainingActions(state));
        return allActions;
    }
}
