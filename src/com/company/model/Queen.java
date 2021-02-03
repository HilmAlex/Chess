package com.company.model;

import com.company.movements.IDiagonalMovement;
import com.company.movements.IStraightDownMovement;
import com.company.movements.IStraightSideMovement;
import com.company.movements.IStraightUpMovement;

import java.awt.*;

public class Queen extends Piece implements IDiagonalMovement, IStraightUpMovement, IStraightDownMovement, IStraightSideMovement {
    public Queen(Color color) {
        super(color);
    }

    public boolean verificarMovimiento(int initialRow, int initialColumn, int finalRow, int finalColumn) {
        if (checkDiagonalMove(initialRow, initialColumn, finalRow, finalColumn)
                        && checkStraightSideMovement(initialRow, initialColumn, finalRow, finalColumn)
                        && checkStraightDownMove(initialRow, initialColumn, finalRow, finalColumn)
                        && checkStraightUpMove(initialRow, initialColumn, finalRow, finalColumn)) {
            return true;
        } else {
            return false;
        }
    }
}
