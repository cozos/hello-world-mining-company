package com.scbot.game.state;

import com.scbot.game.Game;
import com.scbot.game.agent.IUnit;
import com.scbot.game.agent.Unit;

import java.util.Collection;

/**
 * Created by User1 on 5/7/2015.
 */
public class GameState {

    private Collection<IUnit> idleWorkers;

    private Collection<IUnit> neutralUnits;

    public GameState(Collection<IUnit> idleWorkers, Collection<IUnit> neutralUnits){
        this.idleWorkers = idleWorkers;
        this.neutralUnits = neutralUnits;
    }

    public Collection<IUnit> getIdleWorkers() {
        return idleWorkers;
    }

    public Collection<IUnit> getNeutralUnits() {
        return neutralUnits;
    }

}
