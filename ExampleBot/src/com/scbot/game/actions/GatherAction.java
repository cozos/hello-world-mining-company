package com.scbot.game.actions;

import com.scbot.game.Game;

/**
 * Created by User1 on 5/10/2015.
 */
public class GatherAction implements IAction {

    private bwapi.Unit source;

    private bwapi.Unit target;

    public GatherAction(bwapi.Unit source, bwapi.Unit target){
        this.source = source;
        this.target = target;
    }

    public bwapi.Unit getTarget(){
        return target;
    }

    public void execute(){
        source.gather(target);
    }
}
