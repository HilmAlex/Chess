package com.company.movements;

public interface IStraightMovement {

    default boolean straightMove(int initialRow, int initialColumn, int finalRow, int finalColumn) {
        if ( initialRow == finalRow || initialColumn == finalColumn) {
            return true;
        } else return false;
    }
}
