package com.company.model;

import java.awt.*;

public class Locker extends Position{
    private Color color;
    private Piece piece;

    public Locker(Color color, int row, int column, Piece piece) {
        super(row, column);
        this.color = color;
        this.piece = null;

    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
