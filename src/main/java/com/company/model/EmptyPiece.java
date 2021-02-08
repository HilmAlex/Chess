package com.company.model;

import java.awt.*;
import java.util.List;

public class EmptyPiece extends Piece{
    public EmptyPiece() {
        super(Color.cyan);
        setMaxDistance(8);
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
