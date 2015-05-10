package com.scbot.game.agent;

import com.scbot.utils.dto.Position;

/**
 * Created by User1 on 5/4/2015.
 */
public interface IAgent {

    /**
     * Position of the agent on the field.
     * @return
     */
    Position getPosition();

    boolean isIdle();

    boolean isWorker();

    void setIsIdle(boolean isIdle);

    void setIsWorker(boolean isWorker);
}
