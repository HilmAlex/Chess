package com.company.movements;

import com.company.model.Piece;

public interface IMovement {

    default void pieceMoveInterface(
            Piece[][] pieces, int initialRow, int initialColumn, int finalRow, int finalColumn)
    {
        pieces[finalRow][finalColumn] = pieces[initialRow][initialColumn];
        pieces[initialRow][initialColumn] = null;
    }
}
