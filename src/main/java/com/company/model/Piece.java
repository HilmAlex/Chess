package com.company.model;

import java.awt.*;
import java.util.List;

public abstract class Piece {

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

    // Getters and setters
    public String getImage() {
        return image;
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

    public List<PositionOnBoard> getPossibleMovements() {
        return possibleMovements;
    }

    public void setPossibleMovements(List<PositionOnBoard> possibleMovements) {
        this.possibleMovements = possibleMovements;
    }

    public int getQuantityOfMovements() {
        return quantityOfMovements;
    }

    public void increaseMovement() {
        this.quantityOfMovements++;
    }

    public int getLastMovementRecord() {
        return lastMovementRecord;
    }

    public void setLastMovementRecord(int lastMovementRecord) {
        this.lastMovementRecord = lastMovementRecord;
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
