package com.company;

import com.company.model.ChessBoard;
import com.company.model.Pawn;

public class main {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();

        chessBoard.imprimirCasilla();
        chessBoard.pieceMovement(1,1,2,1);
        chessBoard.imprimirCasilla();
    }
}
