package com.company.movements;

import com.company.model.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

public class IDiagonalMovementTest implements IDiagonalMovement{
    ChessBoard chessBoard = new ChessBoard();
    List<PositionOnBoard> possiblesMovements = new ArrayList<PositionOnBoard>();
    List<PositionOnBoard> expectedMovements = new ArrayList<PositionOnBoard>();


    @After
    public void tearDown() throws Exception {
        possiblesMovements.forEach(System.out::println);
    }

    @Test
    public void possibles_diagonal_movements_D5_up_and_right() {
        possiblesMovements = getSquares(chessBoard.getLockers(), new PositionOnBoard(3,3), 1,1);
    }

    @Test
    public void possibles_diagonal_movements_D5_up_and_left() {
        possiblesMovements = getSquares(chessBoard.getLockers(), new PositionOnBoard(3,3), 1,-1);
    }

    @Test
    public void possibles_diagonal_movements_D5_down_and_right() {
        possiblesMovements = getSquares(chessBoard.getLockers(), new PositionOnBoard(3,3), -1,1);
    }

    @Test
    public void possibles_diagonal_movements_D5_down_and_left() {
        possiblesMovements = getSquares(chessBoard.getLockers(), new PositionOnBoard(3,3), -1,-1);
    }

    @Test
    public void all_possibles_diagonal_movements_D5() {
        possiblesMovements = possibleDiagonalMovements(chessBoard.getLockers(),new PositionOnBoard(3,3) );
    }
}