package com.scbot.game.agent;

import com.scbot.game.actions.IAction;
import com.scbot.game.state.GameState;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by User1 on 5/13/2015.
 */
public abstract class HeirarchicalAgent implements IAgent{

    private Collection<HeirarchicalAgent> children;

    public HeirarchicalAgent(Collection<HeirarchicalAgent> children){
        this.children = children;
    }

    public HeirarchicalAgent(){
        this(Collections.emptyList());
    }

    @Override
    public Collection<IAction> getActions(GameState state) {
        Collection<IAction> actions = new ArrayList<>();
        children.forEach(c -> actions.addAll(c.getActions(state)));
        return actions;
    }
}
