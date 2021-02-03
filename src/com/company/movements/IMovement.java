package com.company.movements;

import com.company.model.Locker;
import com.company.model.Piece;

public interface IMovement {

    default void pieceMoveInterface(
            Locker[][] lockers, int initialRow, int initialColumn, int finalRow, int finalColumn)
    {
        lockers[finalRow][finalColumn].setPiece(lockers[initialRow][initialColumn].getPiece());
        lockers[initialRow][initialColumn].setPiece(null);
    }
}
