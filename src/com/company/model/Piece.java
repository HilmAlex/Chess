package com.company.model;

import java.awt.*;

public abstract class Piece{
    private int row;
    private int column;
    private Color color;
    public Piece(int row, int column, Color color) {
        this.row = row;
        this.column = column;
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " " + String.valueOf("") ;
    }
}
