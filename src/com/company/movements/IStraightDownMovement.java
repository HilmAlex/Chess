package com.company.movements;

public interface IStraightDownMovement {
    default boolean checkStraightDownMove(int initialRow, int initialColumn, int finalRow, int finalColumn) {
        if ( initialRow == finalRow && (finalRow - initialRow < 0)) {
            return true;
        } else return false;
    }
}
