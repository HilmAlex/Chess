package com.company.movements;

public interface IStraightSideMovement {
    default boolean checkStraightSideMovement(int initialRow, int initialColumn, int finalRow, int finalColumn) {
        if ( initialColumn == finalColumn) {
            return true;
        } else return false;
    }
}
