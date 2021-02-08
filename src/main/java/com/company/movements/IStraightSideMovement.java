package com.company.movements;

import com.company.model.PositionOnBoard;

public interface IStraightSideMovement {
    default boolean checkStraightSideMovement(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        if ( initialPosition.getColumn() == finalPosition.getColumn()) {
            return true;
        } else return false;
    }
}
