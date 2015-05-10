package com.scbot.game.player;

import com.scbot.game.actions.GatherAction;
import com.scbot.game.agent.IAgent;
import com.scbot.game.agent.IUnit;
import com.scbot.game.state.GameState;
import com.scbot.providers.UnitProvider;
import com.scbot.game.actions.Action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by User1 on 5/4/2015.
 */
public class AI implements IPlayer, IAgent{

    private int playerID;

    public AI(int playerID){
        this.playerID = playerID;
    }

    public int getID(){
        return this.playerID;
    }

    public Collection<Action> getActions(GameState gameState){

        Collection<IUnit> idleWorkers = gameState.getIdleWorkers();
        Collection<IUnit> mineralFields = gameState.getMineralFields();

        Collection<Action> actions = new ArrayList<>();

        for(IUnit unit : idleWorkers){
            IUnit closestMineral = null;
            for(IUnit mineral : mineralFields){
                if(closestMineral==null || unit.getDistance(mineral) < unit.getDistance(closestMineral)){
                    closestMineral = mineral;
                }
            }

            if(closestMineral != null){
                actions.add(new GatherAction(unit.getID(), closestMineral.getID()));
            }
        }

        return actions;
    }
}
