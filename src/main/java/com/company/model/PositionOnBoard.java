package com.company.model;

import java.util.Objects;

public class PositionOnBoard {
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

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public PositionOnBoard getPosition(){
        return this;
    }

    @Override
    public String toString() {
        return "row = " + row +
                "column = " + column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionOnBoard that = (PositionOnBoard) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
