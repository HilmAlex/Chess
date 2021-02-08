package com.company.model;

import com.company.movements.IStraightSideMovement;
import com.company.movements.IStraightVerticalMovement;

import java.awt.*;
import java.util.List;

public class Rock extends Piece implements IStraightVerticalMovement, IStraightSideMovement {
    public Rock(Color color) {
        super(color);
        this.setMaxDistance(8);
        this.setImage(color.equals(Color.BLACK)? "src/main/java/images/blackRock.png" : "src/main/java/images/whiteRock.png");
    }

    @Override
    public List<PositionOnBoard> possibleMovements(Locker[][] lockers, PositionOnBoard initialPosition){
        return null;
    }

    @Override
    public boolean checkMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        return false;
    }

}
