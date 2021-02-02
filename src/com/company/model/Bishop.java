package com.company.model;

import com.company.movements.IDiagonalMovement;

import java.awt.*;

public class Bishop extends Piece implements IDiagonalMovement {
    public Bishop(int row, int column, Color color) {
        super(row, column, color);
    }


}
