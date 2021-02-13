package com.company.model;

import lombok.Data;

import javax.swing.text.Position;
import java.util.Objects;

public @Data class PositionOnBoard {
    private int row;
    private int column;

    public PositionOnBoard(int row, int column){
        this.row = row;
        this.column = column;
    }

    public PositionOnBoard(PositionOnBoard positionOnBoard) {
        this.row = positionOnBoard.getRow();
        this.column = positionOnBoard.getColumn();
    }

    public PositionOnBoard getPosition(){
        return this;
    }

}
