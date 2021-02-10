package com.company.model;

import java.awt.*;
import java.util.Objects;

public class Locker extends PositionOnBoard {
    private Color color;
    private Piece piece;

    public Locker(Color color, int row, int column) {
        super(row, column);
        this.color = color;
        this.piece = null;

    }

    public Locker(int row, int column) {
        super(row, column);
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

    @Override
    public String toString() {
        return getRow() + " " + getColumn();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locker locker = (Locker) o;
        return Objects.equals(color, locker.color) && Objects.equals(piece, locker.piece);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, piece);
    }
}
