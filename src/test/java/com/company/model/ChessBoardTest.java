package com.company.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ChessBoardTest {
    ChessBoard chessBoard = new ChessBoard();

    @Test
    public void move_pawn_B1_to_B2() throws Exception {
        chessBoard.movePiece(1,1,3,1);

    }


}