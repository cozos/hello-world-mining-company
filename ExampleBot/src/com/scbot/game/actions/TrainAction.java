package com.scbot.game.actions;

import bwapi.Unit;
import bwapi.UnitType;
import com.scbot.game.Game;

/**
 * Created by User1 on 5/10/2015.
 */
public class TrainAction implements IAction {

    private bwapi.Unit trainer;

    private UnitType type;

    public TrainAction(bwapi.Unit trainer, UnitType type){
        this.trainer = trainer;
        this.type = type;
    }

    public void execute(){
        trainer.train(type);
    }

    @Override
    public Unit getTarget() {
        return null;
    }
}

