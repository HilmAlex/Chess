package com.company.movements;

public interface IKnightMove {

    default boolean knightMove(int initialRow, int initialColumn, int finalRow, int finalColumn) {
        if (
                (Math.abs(initialRow - finalRow) == 2 && Math.abs(initialColumn - finalColumn) == 1)
                        ||
                (Math.abs(initialRow - finalRow) == 1 && Math.abs(initialColumn - finalColumn) == 2)
        ) {
            return true;
        } else {
            return false;
        }
    }
}
