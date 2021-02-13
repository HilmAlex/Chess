package com.company.model;

import lombok.Data;

import java.awt.*;
import java.util.List;

public @Data abstract class Piece {

    private int maxDistance;
    private final Color color;
    private String image;
    private int quantityOfMovements;
    private int lastMovementRecord;
    private List<PositionOnBoard> possibleMovements;

    public Piece(Color color) {
        this.maxDistance = 7;
        this.color = color;
        this.quantityOfMovements = 0;
    }

    public abstract void calculatePossibleMovements(Locker[][] lockers, PositionOnBoard initialPosition);

    public abstract boolean checkMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition);

    public void increaseMovement() {
        this.quantityOfMovements++;
    }

    @Override
    public String toString() {
        String colorStr = "";
        if (color.equals(Color.BLACK)) {
            colorStr = "BLACK";
        } else if (color.equals(Color.WHITE)) {
            colorStr = "WHITE";
        }
        return this.getClass().getSimpleName() +
                " " + colorStr;
    }
}
