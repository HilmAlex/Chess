package com.company.model;

import com.company.movements.IStraightDownMovement;
import com.company.movements.IStraightUpMovement;

import java.awt.*;

public class Rock extends Piece implements IStraightUpMovement, IStraightDownMovement {
    public Rock(Color color) {
        super(color);
    }

}
