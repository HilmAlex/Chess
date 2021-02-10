package com.company.movements;

import com.company.model.Locker;
import com.company.model.PositionOnBoard;

import java.util.List;

public interface IKnightMove extends IMovement {

    default boolean checkKnightMove(int initialRow, int initialColumn, int finalRow, int finalColumn) {
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

    default List<PositionOnBoard> possibleKnightMovements(Locker[][] lockers, PositionOnBoard initialPosition) {
        List<PositionOnBoard> possibleMovements;

        possibleMovements = getSquares(lockers, initialPosition, 1, 2);
        possibleMovements.addAll(getSquares(lockers, initialPosition, 1, -2));
        possibleMovements.addAll(getSquares(lockers, initialPosition, -1, 2));
        possibleMovements.addAll(getSquares(lockers, initialPosition, -1, -2));
        possibleMovements.addAll(getSquares(lockers, initialPosition, 2, 1));
        possibleMovements.addAll(getSquares(lockers, initialPosition, 2,-1));
        possibleMovements.addAll(getSquares(lockers, initialPosition, -2, 1));
        possibleMovements.addAll(getSquares(lockers, initialPosition, -2, -1));

        return possibleMovements;
    }
}
