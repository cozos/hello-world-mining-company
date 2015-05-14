package com.scbot.game.actions;

import com.scbot.game.Game;

/**
 * Created by User1 on 5/10/2015.
 */
public class GatherAction implements IAction {

    private int unitID;

    private int targetUnitID;

    public GatherAction(int unitID, int targetUnitID){
        this.unitID = unitID;
        this.targetUnitID = targetUnitID;
    }

    public int getTargetID(){
        return this.targetUnitID;
    }

    public void execute(){
        Game.getUnit(unitID).gather(Game.getUnit(targetUnitID), false);
    }
}
