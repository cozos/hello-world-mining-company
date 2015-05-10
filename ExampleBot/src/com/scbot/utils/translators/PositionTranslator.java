package com.scbot.utils.translators;

import com.scbot.utils.dto.Position;

/**
 * Created by User1 on 5/4/2015.
 */
public class PositionTranslator {
    public static Position translatePosition(bwapi.Position bpos){
        return new Position(bpos.getX(), bpos.getY());
    }
}
