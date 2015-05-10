package com.scbot.game.state;

import com.scbot.delegators.IGameBotDelegator;
import com.scbot.game.Game;
import com.scbot.game.agent.Agent;

import java.util.Collection;

/**
 * Created by User1 on 5/7/2015.
 */
public class GameState implements IGameState {

    private Game game;

    private Collection<Agent> playerUnits;

    private Collection<Agent> enemyUnits;

    public GameState(Game game){
        this.game = game;
    }

    public Collection<Agent> getPlayerUnits() {
        return playerUnits;
    }

    public Collection<Agent> getEnemyUnits() {
        return enemyUnits;
    }

    // TODO
    public void update(){
    }
}
