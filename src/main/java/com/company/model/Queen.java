package com.company.model;

import com.company.movements.IDiagonalMovement;
import com.company.movements.IStraightSideMovement;
import com.company.movements.IStraightVerticalMovement;

import java.awt.*;
import java.util.List;

public class Queen extends Piece implements IDiagonalMovement, IStraightVerticalMovement, IStraightSideMovement {
    private int maxDistance = 8;
    public Queen(Color color) {
        super(color);
        this.setImage(color.equals(Color.BLACK)? "src/main/java/images/blackQueen.png" : "src/main/java/images/whiteQueen.png");
    }

    @Override
    public List<PositionOnBoard> possibleMovements(Locker[][] lockers, PositionOnBoard initialPosition) {
        return null;
    }

    @Override
    public boolean checkMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        return false;
    }

    public boolean efef(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        if (checkDiagonalMove(initialPosition, finalPosition)
                &&
                checkStraightSideMovement(initialPosition, finalPosition)
                &&
                checkStraightVerticalMove(initialPosition, finalPosition)){
            return true;
        } else {
            return false;
        }
    }
}
