package com.company.model;

import com.company.movements.IHorizontalMovement;
import com.company.movements.IVerticalMovement;

import java.awt.*;
import java.util.List;

public class Rock extends Piece implements IVerticalMovement, IHorizontalMovement {
    public Rock(Color color) {
        super(color);
        this.setMaxDistance(7);
        this.setImage(color.equals(Color.BLACK)? "C:\\Users\\Alex\\IdeaProjects\\Chess\\src\\main\\java\\images\\blackRock.png" : "C:\\Users\\Alex\\IdeaProjects\\Chess\\src\\main\\java\\images\\whiteRock.png");
    }

    @Override
    public void calculatePossibleMovements(Locker[][] lockers, PositionOnBoard initialPosition) {
        List<PositionOnBoard> possibleMovements;

        possibleMovements = possibleVerticalMovements(lockers, initialPosition);
        possibleMovements.addAll(possibleHorizontalMovements(lockers, initialPosition));

        this.setPossibleMovements(possibleMovements);
    }

    @Override
    public boolean checkMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        return checkVerticalMove(initialPosition, finalPosition)
                && checkHorizontalMovement(initialPosition, finalPosition);
    }

}
