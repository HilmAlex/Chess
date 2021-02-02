package com.company.movements;

public interface IDiagonalMovement {

    default boolean checkDiagonalMove(int initialRow, int initialColumn, int finalRow, int finalColumn) {
        if (Math.abs(finalColumn - initialColumn) / (finalRow - finalColumn) == 1) {
            return true;
        } else return false;
    }
}
