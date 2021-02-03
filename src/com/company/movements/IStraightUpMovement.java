package com.company.movements;

public interface IStraightUpMovement {

    default boolean checkStraightUpMove(int initialRow, int initialColumn, int finalRow, int finalColumn) {
        if ( initialRow == finalRow && (finalRow - initialRow > 0)) {
            return true;
        } else return false;
    }
}
