package com.scbot.builders;

import com.scbot.game.state.GameState;
import com.scbot.providers.UnitProvider;
import com.scbot.proxies.BWListener;

/**
 * Created by User1 on 5/10/2015.
 */
public class GameStateBuilder {

    private static UnitProvider provider = new UnitProvider(BWListener.game);

    private static GameState instance;

    private static GameStateBuilder builderInstance = new GameStateBuilder();

    public static GameStateBuilder requestGameState(int playerID){
        instance = new GameState(provider.getIdleWorkers(playerID), provider.getNeutralUnits());
        return builderInstance;
    }

    public static GameState build(){
        return instance;
    }
}
