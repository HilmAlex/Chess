package com.company.model;

import java.awt.*;

public class Pawn extends Piece implements {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean checkMove() {
        return false;
    }
}
