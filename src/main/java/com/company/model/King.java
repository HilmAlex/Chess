package com.company.model;

import java.awt.*;
import java.util.List;

public class King extends Piece{
    public King(Color color) {
        super(color);
        this.setImage(color.equals(Color.BLACK)? "src/main/java/images/blackKing.png" : "src/main/java/images/whitePawn.png");
        this.setMaxDistance(1);
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
