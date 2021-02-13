package com.company.model;

import lombok.Data;

import java.awt.*;

public @Data class Locker{
    private PositionOnBoard position;
    private Color color;
    private Piece piece;

    public Locker(Color color, int row, int column) {
        this.position=new PositionOnBoard(row, column);
        this.color = color;
        this.piece = null;

    }

    public Locker(int row, int column) {
        this.position=new PositionOnBoard(row, column);;
    }

    @Override
    public String toString() {
        return position.getRow() + " " + position.getColumn();
    }
}
