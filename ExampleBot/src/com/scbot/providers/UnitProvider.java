package com.scbot.providers;

import com.scbot.builders.UnitBuilder;
import com.scbot.game.Game;
import com.scbot.game.agent.Unit;

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

    public Collection<Unit> getAgents(bwapi.Player player){
        return player.getUnits().stream()
                .map(unit -> builder.buildAgent(unit).build())
                .collect(Collectors.toList());
    }

    public Collection<bwapi.Unit> getBuildings(bwapi.Player player){
        return player.getUnits().stream()
                .filter(u -> u.getType().isBuilding())
                .collect(Collectors.toList());
    }

    public Collection<Unit> getIdleWorkers(bwapi.Player player){
        return player.getUnits().stream()
                .filter(u -> u.getType().isWorker() && u.isIdle())
                .map(unit -> builder.buildAgent(unit).build())
                .collect(Collectors.toList());
    }

    public Collection<bwapi.Unit> getMineralFields(){
        return game.getNeutralUnits().stream()
                .filter(unit -> unit.getType().isMineralField())
                .collect(Collectors.toList());
    }
}
