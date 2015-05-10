package com.scbot.game;

import bwapi.Player;
import bwapi.Unit;

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

    /**
     * @param ID of some Player in the game
     * @return Units of player
     */
    public Collection<Unit> getUnits(int ID){
        for(Player p : game.getPlayers()){
            if(p.getID()==ID){
                return p.getUnits();
            }
        }
        return null;
    }

    public Collection<Unit> getNeutralUnits() {
        return game.neutral().getUnits();
    }
}
