package com.scbot.builders;

import bwapi.Unit;
import com.scbot.game.agent.Agent;
import com.scbot.game.agent.IAgent;
import com.scbot.utils.translators.PositionTranslator;

/**
 * Created by User1 on 5/4/2015.
 */
public class AgentBuilder {

    private IAgent instance;

    public AgentBuilder buildAgent(Unit unit) {
        instance = new Agent(PositionTranslator.translatePosition(unit.getPosition()));
        this.withIdleStatus(unit.isIdle()).withWorkerStatus(unit.getType().isWorker());
        return this;
    }

    public AgentBuilder withWorkerStatus(boolean isWorker){
        instance.setIsWorker(isWorker);
        return this;
    }

    public AgentBuilder withIdleStatus(boolean isIdle){
        instance.setIsIdle(isIdle);
        return this;
    }

    public IAgent build(){
        return instance;
    }
}
