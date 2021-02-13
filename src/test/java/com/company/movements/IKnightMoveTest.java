package com.company.movements;

import com.company.model.ChessBoard;
import com.company.model.EmptyPiece;
import com.company.model.PositionOnBoard;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class IKnightMoveTest implements IKnightMove {
    List<PositionOnBoard> possiblesMovements = new ArrayList<PositionOnBoard>();

    ChessBoard chessBoard = new ChessBoard();

    @After
    public void tearDown() throws Exception {
        possiblesMovements.forEach(System.out::println);
    }

    @Test
    public void possibles_movements_D5() {
        possiblesMovements = possibleKnightMovements(chessBoard.getLockers(), new PositionOnBoard(3, 3));
    }

    @Test
    public void possibles_movements_G3() {
        possiblesMovements = possibleKnightMovements(chessBoard.getLockers(), new PositionOnBoard(2, 6));
    }

    @Test
    public void possibles_movements_H3() {
        possiblesMovements = possibleKnightMovements(chessBoard.getLockers(), new PositionOnBoard(2, 7));
    }

    @Test
    public void possibles_movements_H1() {
        possiblesMovements = possibleKnightMovements(chessBoard.getLockers(), new PositionOnBoard(0, 7));
    }
}