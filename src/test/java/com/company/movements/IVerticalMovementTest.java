package com.company.movements;

import com.company.model.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

public class IVerticalMovementTest implements IVerticalMovement, IHorizontalMovement {
    List<PositionOnBoard> possiblesMovements = new ArrayList<PositionOnBoard>();
    List<PositionOnBoard> expectedMovements = new ArrayList<PositionOnBoard>();

    ChessBoard chessBoard = new ChessBoard();

    @After
    public void tearDown() throws Exception {
        possiblesMovements.forEach(System.out::println);
    }

    @Test
    public void get_all_possibles_moves_white_rock_C3() {
        chessBoard.getLockers()[3][3] = new Locker(3, 3);
        chessBoard.getLockers()[3][3].setPiece(new Rock(Color.WHITE));
        possiblesMovements = possibleVerticalMovements(chessBoard.getLockers(),
                new PositionOnBoard(3, 3));
    }

    @Test
    public void get_all_possibles_moves_white_King_C3() {
        chessBoard.getLockers()[3][3] = new Locker(3, 3);
        chessBoard.getLockers()[3][3].setPiece(new King(Color.WHITE));
        possiblesMovements = possibleVerticalMovements(chessBoard.getLockers(),
                new PositionOnBoard(3, 3));
    }

    @Test
    public void get_up_possibles_moves_white_rock_C3() {
        chessBoard.getLockers()[3][3] = new Locker(3, 3);
        chessBoard.getLockers()[3][3].setPiece(new Rock(Color.WHITE));
        possiblesMovements = possibleVerticalMovements(chessBoard.getLockers(), new PositionOnBoard(3, 3));
    }

    @Test
    public void get_up_possibles_moves_black_rock_C3() {

        chessBoard.getLockers()[3][3] = new Locker(3, 3);
        chessBoard.getLockers()[3][3].setPiece(new Rock(Color.BLACK));
        chessBoard.imprimirCasilla();
        possiblesMovements = possibleVerticalMovements(chessBoard.getLockers(), new PositionOnBoard(3, 3));
        possiblesMovements.addAll(possibleHorizontalMovements(chessBoard.getLockers(), new PositionOnBoard(3, 3)));

    }


    @Test
    public void get_up_possibles_moves_black_pawn_B2() {
        possiblesMovements = getSquares(chessBoard.getLockers(), new PositionOnBoard(1, 1), 1, 0);

    }

    @Test
    public void get_up_possibles_moves_black_rock_A1() {
        chessBoard.imprimirCasilla();
        possiblesMovements = getSquares(chessBoard.getLockers(), new PositionOnBoard(0, 0), 1, 0);
        assertEquals(expectedMovements, possiblesMovements);
    }

    @Test
    public void get_down_possibles_moves_D4() {
        possiblesMovements = getSquares(chessBoard.getLockers(), new PositionOnBoard(3, 3), -1, 0);

        /*expectedMovements.add(new PositionOnBoard(2, 3));
        expectedMovements.add(new PositionOnBoard(1, 3));

        possiblesMovements.stream().sorted(Comparator.comparing(PositionOnBoard::getRow));
        expectedMovements.stream().sorted(Comparator.comparing(PositionOnBoard::getRow));

        expectedMovements.forEach(System.out::println);

        assertEquals(possiblesMovements, expectedMovements);

         */
    }

}