package com.scbot.proxies;

import bwapi.DefaultBWListener;
import bwapi.Mirror;
import bwapi.Unit;
import bwta.BWTA;
import com.scbot.game.Game;
import com.scbot.game.player.*;

public class BWListener extends DefaultBWListener implements Runnable{

    private Player player;

    public static Mirror mirror = new Mirror();

    public BWListener(Player player){
        this.player = player;
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
    }

    @Override
    public void onFrame() {
        player.update();
    }
}

