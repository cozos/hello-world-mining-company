package com.scbot.game.state;

import com.scbot.game.agent.IUnit;

import java.util.Collection;

/**
 * Created by User1 on 5/7/2015.
 */
public class GameState {

    private Collection<IUnit> idleWorkers;

    private Collection<IUnit> mineralFields;

    public GameState(Collection<IUnit> idleWorkers, Collection<IUnit> mineralFields){
        this.idleWorkers = idleWorkers;
        this.mineralFields = mineralFields;
    }

    public Collection<IUnit> getIdleWorkers() {
        return idleWorkers;
    }

    public Collection<IUnit> getMineralFields() {
        return mineralFields;
    }

    public void occupyMineral(int id){
        for(IUnit mineral : mineralFields){
            if(mineral.getID() == id){
                mineralFields.remove(mineral);
                return;
            }
        }
    }
}
