package com.company.model;

import com.company.movements.IDiagonalMovement;

import java.awt.*;
import java.util.List;

public class Bishop extends Piece implements IDiagonalMovement {
    public Bishop(Color color) {
        super(color);
        this.setImage(color.equals(Color.BLACK)? "src/main/java/images/blackBishop.png" : "src/main/java/images/whiteBishop.png");
    }

    private int maxDistance;
    public List<PositionOnBoard> possibleMovements(Locker[][] lockers, PositionOnBoard initialPosition) {
        return null;
    }

    @Override
    public boolean checkMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        return false;
    }
}


