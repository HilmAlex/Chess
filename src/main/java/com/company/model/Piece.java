package com.company.model;

import java.awt.*;
import java.util.List;

public abstract class Piece {

    public enum typePiece {
        Rock, Knight, Bishop, Queen, King, Pawn
    }
    private int maxDistance;
    private Color color;
    private String image;

    public Piece(Color color) {
        this.color = color;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public Color getColor() {
        return color;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public abstract List<PositionOnBoard> possibleMovements(Locker[][] lockers, PositionOnBoard initialPosition);

    public abstract boolean checkMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition);

    @Override
    public String toString() {
        String colorStr = "";
        if (color.equals(Color.BLACK)) {
            colorStr = "BLACK";
        } else if(color.equals(Color.WHITE)){
            colorStr = "WHITE";
        }
        return this.getClass().getSimpleName() +
                " " + colorStr;
    }


}
