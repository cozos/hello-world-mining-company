package com.scbot.game.state;

import com.scbot.game.agent.Unit;

import java.util.Collection;

/**
 * Created by User1 on 5/7/2015.
 */
public class GameState {

    private Collection<Unit> idleWorkers;

    private Collection<bwapi.Unit> mineralFields;

    public GameState(Collection<Unit> idleWorkers, Collection<bwapi.Unit> mineralFields){
        this.idleWorkers = idleWorkers;
        this.mineralFields = mineralFields;
    }

    public Collection<Unit> getIdleWorkers() {
        return idleWorkers;
    }

    public Collection<bwapi.Unit> getMineralFields() {
        return mineralFields;
    }

    public void occupyMineral(bwapi.Unit unit){
        for(bwapi.Unit mineral : mineralFields){
            if(mineral.getID() == unit.getID()){
                mineralFields.remove(mineral);
                return;
            }
        }
    }
}
