package com.scbot.proxies;

import bwapi.DefaultBWListener;
import bwapi.Mirror;
import bwapi.Unit;
import bwta.BWTA;
import com.scbot.builders.GameStateBuilder;
import com.scbot.game.Game;
import com.scbot.game.player.*;
import com.scbot.game.state.GameState;
import com.scbot.providers.UnitProvider;
import com.scbot.game.actions.Action;

import java.util.Collection;
import java.util.Collections;

public class BWListener extends DefaultBWListener implements Runnable{

    private AI AI;

    private bwapi.Game gameRef;

    public static Mirror mirror = new Mirror();

    public static Game game;

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
        System.out.println("Init gameRef");
        this.gameRef = mirror.getGame();
        this.game = new Game(this.gameRef);
        AI = new AI(gameRef.self().getID());
    }

    @Override
    public void onFrame() {
        // 23 FPS. Update every second.
        if(gameRef.getFrameCount() == 23){
            GameState gameState = GameStateBuilder.requestGameState(AI.getID()).build();
            AI.getActions(gameState).stream().forEach(action -> action.execute());
        }
    }
}

