package com.scbot;

import bwapi.Mirror;
import com.scbot.game.player.Player;
import com.scbot.proxies.BWListener;


/**
 * Created by User1 on 5/3/2015.
 */
public class main {
    public static void main(String [] args){
        BWListener listener = new BWListener(new Player());
        listener.run();
    }
}
