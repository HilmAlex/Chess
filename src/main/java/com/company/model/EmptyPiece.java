package com.company.model;

import java.awt.*;
import java.util.List;

public class EmptyPiece extends Piece{
    public EmptyPiece() {
        super(Color.cyan);
        setMaxDistance(1);
    }

    @Override
    public void calculatePossibleMovements(Locker[][] lockers, PositionOnBoard initialPosition) {
    }

    @Override
    public boolean checkMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        return false;
    }
}
