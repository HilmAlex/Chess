package com.company.model;

import com.company.movements.IDiagonalMovement;
import com.company.movements.IStraightMovement;

import java.awt.*;

public class Queen extends Piece implements IDiagonalMovement, IStraightMovement {
    public Queen( Color color) {
        super(color);
    }

}
