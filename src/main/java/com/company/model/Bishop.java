package com.company.model;

import com.company.movements.IDiagonalMovement;

import java.awt.*;
import java.util.List;

public class Bishop extends Piece implements IDiagonalMovement {
    public Bishop(Color color) {
        super(color);
        setMaxDistance(7);
        this.setImage(color.equals(Color.BLACK) ? "src/main/java/images/blackBishop.png" : "src/main/java/images/whiteBishop.png");
    }

    @Override
    public void calculatePossibleMovements(Locker[][] lockers, PositionOnBoard initialPosition) {
        List<PositionOnBoard> possibleMovements;

        possibleMovements = possibleDiagonalMovements(lockers, initialPosition);

        this.setPossibleMovements(possibleMovements);
    }

    @Override
    public boolean checkMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        return checkDiagonalMove(initialPosition, finalPosition);
    }
}


