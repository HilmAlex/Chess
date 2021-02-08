package com.company.model;

import java.awt.*;
import java.util.List;

public class Knight extends Piece{
    public Knight(Color color) {
        super(color);
        this.setImage(color.equals(Color.BLACK)? "src/main/java/images/blackKnight.png" : "src/main/java/images/whiteKnight.png");
    }

    @Override
    public List<PositionOnBoard> possibleMovements(Locker[][] lockers, PositionOnBoard initialPosition) {
        return null;
    }

    @Override
    public boolean checkMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        return false;
    }
}
