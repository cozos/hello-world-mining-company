package com.scbot.game.state;

import com.scbot.game.Game;
import com.scbot.game.agent.Unit;

import java.util.Collection;

/**
 * Created by User1 on 5/7/2015.
 */
public class GameState implements IGameState {


    private Collection<Unit> playerUnits;

    private Collection<Unit> enemyUnits;

    public GameState(){
    }

    public Collection<Unit> getPlayerUnits() {
        return playerUnits;
    }

    public Collection<Unit> getEnemyUnits() {
        return enemyUnits;
    }

}
