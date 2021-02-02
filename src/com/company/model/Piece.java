package com.company.model;

import java.awt.*;

public abstract class Piece{
    public enum typePiece{
        Rock, Knight, Bishop, Queen, King, Pawn
    }

    private Color color;
    private String image;

    public Piece(Color color) {
        this.color = color;
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
