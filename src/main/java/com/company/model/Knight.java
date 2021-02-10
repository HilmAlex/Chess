package com.company.model;

import com.company.movements.IKnightMove;

import java.awt.*;
import java.util.List;

public class Knight extends Piece implements IKnightMove {
    public Knight(Color color) {
        super(color);
        this.setMaxDistance(1);
        this.setImage(color.equals(Color.BLACK)? "src/main/java/images/blackKnight.png" : "src/main/java/images/whiteKnight.png");
    }

    @Override
    public void calculatePossibleMovements(Locker[][] lockers, PositionOnBoard initialPosition) {
        List<PositionOnBoard> possibleMovements;

        possibleMovements = possibleKnightMovements(lockers, initialPosition);

        this.setPossibleMovements(possibleMovements);
    }

    @Override
    public boolean checkMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        return false;
    }
}
