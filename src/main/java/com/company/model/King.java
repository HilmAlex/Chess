package com.company.model;

import com.company.movements.IDiagonalMovement;
import com.company.movements.IHorizontalMovement;
import com.company.movements.IVerticalMovement;

import java.awt.*;
import java.util.List;

public class King extends Piece implements IDiagonalMovement, IVerticalMovement, IHorizontalMovement {
    public King(Color color) {
        super(color);
        this.setImage(color.equals(Color.BLACK) ? "src/main/java/images/blackKing.png" : "src/main/java/images/whitePawn.png");
        this.setMaxDistance(1);
    }

    @Override
    public void calculatePossibleMovements(Locker[][] lockers, PositionOnBoard initialPosition) {
        List<PositionOnBoard> possibleMovements;

        possibleMovements = possibleVerticalMovements(lockers, initialPosition);
        possibleMovements.addAll(possibleHorizontalMovements(lockers, initialPosition));
        possibleMovements.addAll(possibleDiagonalMovements(lockers, initialPosition));

        this.setPossibleMovements(possibleMovements);
    }

    @Override
    public boolean checkMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        return checkDiagonalMove(initialPosition, finalPosition)
                &&
                checkHorizontalMovement(initialPosition, finalPosition)
                &&
                checkVerticalMove(initialPosition, finalPosition);
    }
}
