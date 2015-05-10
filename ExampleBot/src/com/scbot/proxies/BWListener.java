package com.scbot.proxies;

import bwapi.DefaultBWListener;
import bwapi.Mirror;
import bwapi.Unit;
import bwta.BWTA;
import com.scbot.game.Game;
import com.scbot.game.player.*;
import com.scbot.game.state.GameState;
import com.scbot.providers.UnitProvider;
import com.scbot.game.actions.Action;

import java.util.Collection;
import java.util.Collections;

public class BWListener extends DefaultBWListener implements Runnable{

    private AI AI;

    private bwapi.Game game;

    public static Mirror mirror = new Mirror();

    public BWListener(){
    }

    public void run(){
        mirror.getModule().setEventListener(this);
        mirror.startGame();
    }

    @Override
    public void onUnitCreate(Unit unit) {
    }

    @Override
    public void onStart() {
        BWTA.readMap();
        BWTA.analyze();
        System.out.println("Init game");
        this.game = mirror.getGame();
        AI = new AI(game.self().getID(), new UnitProvider(new Game(this.game)), Collections.emptyList());
    }

    @Override
    public void onFrame() {
        // 23 FPS. Update every second.
        if(game.getFrameCount() == 23){
            // TODO: GameState builder
            GameState gameState = new GameState();
            Collection<Action> actions = AI.getActions(gameState);
            for (Action action : actions){
                // TODO: execute actions
            }
        }
    }
}

