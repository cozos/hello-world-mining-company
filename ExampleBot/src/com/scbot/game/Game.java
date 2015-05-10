package com.scbot.game;

import bwapi.Unit;
import com.scbot.game.player.Player;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by User1 on 5/7/2015.
 */
public class Game {

    private bwapi.Game game;

    public Game(bwapi.Game game){
        System.out.println("Constructing game");
        this.game = game;
    }

    public Collection<Unit> getPlayerUnits(){
        return game.self().getUnits();
    }

    public Collection<Unit> getEnemyUnits(){

        Collection<Unit> units = new ArrayList<>();

        game.getPlayers()
                .stream()
                .filter(p -> p.isEnemy(game.self()))
                .map(p -> units.addAll(p.getUnits()));

        return units;
    }
}
