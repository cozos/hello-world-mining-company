package com.scbot.game.state;

import bwapi.UnitType;
import com.scbot.game.agent.Unit;

import java.util.Collection;

/**
 * Created by User1 on 5/7/2015.
 */
public class GameState {

    private Collection<Unit> idleWorkers;

    private Collection<bwapi.Unit> mineralFields;

    private Collection<bwapi.Unit> buildings;

    public GameState(Collection<Unit> idleWorkers,
                     Collection<bwapi.Unit> buildings,
                     Collection<bwapi.Unit> mineralFields){
        this.buildings = buildings;
        this.idleWorkers = idleWorkers;
        this.mineralFields = mineralFields;
    }

    public bwapi.Unit getCommandCenter(){
        for(bwapi.Unit building : buildings){
            if (building.getType() == UnitType.Terran_Command_Center){
                return building;
            }
        }
        return null;
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
