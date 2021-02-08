package com.company.model;

import com.company.movements.IMovement;
import org.junit.After;
import org.junit.Test;

public class PawnTest implements IMovement {
    ChessBoard chessBoard = new ChessBoard();

    @After
    public void tearDown() throws Exception {
       chessBoard.imprimirCasilla();
    }

    @Test
    public void move_pawn_B2_to_B3() throws Exception {
        chessBoard.movePiece(1,1,2,1);
    }

    @Test
    public void move_pawn_B2_to_B4() throws Exception {
        chessBoard.movePiece(1,1,3,1);
    }

    @Test
    public void move_pawn_D2_to_D4_and_D4_to_D5() throws Exception {
        chessBoard.movePiece(1,3,3,3);
        chessBoard.movePiece(3,3,4,3);
    }

    @Test
    public void move_pawn_F2_to_F4_and_F4_to_F6() throws Exception {
        chessBoard.movePiece(1,5,3,5);
        chessBoard.movePiece(3,5,5,5);
    }

    @Test
    public void move_pawn_B2_to_B1() throws Exception {
        chessBoard.movePiece(1,1,0,1);
    }

    @Test
    public void move_pawn_C2_to_B3() throws Exception {
        chessBoard.movePiece(1,2,2,1);
    }

}