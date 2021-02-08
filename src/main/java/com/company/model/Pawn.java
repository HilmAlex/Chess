package com.company.model;

import com.company.movements.IStraightVerticalMovement;

import java.awt.*;
import java.util.List;

public class Pawn extends Piece implements IStraightVerticalMovement {

    public Pawn(Color color) {
        super(color);
        this.setMaxDistance(2);
        this.setImage(color.equals(Color.BLACK) ? "src/main/java/images/blackPawn.png" : "src/main/java/images/whitePawn.png");
    }

    public List<PositionOnBoard> possibleMovements(Locker[][] lockers, PositionOnBoard initialPosition) {
        return possibleStraightVerticalMovements(lockers, initialPosition);
    }

    @Override
    public boolean checkMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        if (checkStraightVerticalMove(initialPosition, finalPosition)) {
            if (this.getColor() == (Color.BLACK)
                    && finalPosition.getRow() - initialPosition.getRow() > 0) {
                return true;
            } else if (this.getColor() == (Color.WHITE)
                    && finalPosition.getRow() - initialPosition.getRow() < 0) {
                return true;
            }
        }
        return false;
    }
}
