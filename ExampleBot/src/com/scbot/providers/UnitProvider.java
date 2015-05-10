package com.scbot.providers;

import com.scbot.builders.UnitBuilder;
import com.scbot.game.Game;
import com.scbot.game.agent.IUnit;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by User1 on 5/4/2015.
 */
public class UnitProvider implements IUnitProvider {

    private Game game;

    private UnitBuilder builder;

    public UnitProvider(Game game){
        this.game = game;
        this.builder = new UnitBuilder();
    }

    public Collection<IUnit> getAgents(int ID){
        return game.getUnits(ID).stream()
                .map(unit -> builder.buildAgent(unit).build())
                .collect(Collectors.toList());
    }

    public Collection<IUnit> getIdleWorkers(int ID){
        return game.getUnits(ID).stream()
                .filter(u -> u.getType().isWorker() && u.isIdle())
                .map(unit -> builder.buildAgent(unit).build())
                .collect(Collectors.toList());
    }

    public Collection<IUnit> getMineralFields(){
        return game.getNeutralUnits().stream()
                .filter(unit -> unit.getType().isMineralField())
                .map(unit -> builder.buildAgent(unit).build())
                .collect(Collectors.toList());
    }
}
