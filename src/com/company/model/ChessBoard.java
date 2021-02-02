package com.company.model;

import com.company.movements.IMovement;

import java.awt.*;

public class ChessBoard implements IMovement {
    private Piece[][] pieces = new Piece[8][8];

    public ChessBoard() {
        fillBoard();
    }

    private void fillBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i == 0 && j == 0) || (i == 0 && j == 7)) {   // Black Rock
                    pieces[i][j] = new Rock(i, j, Color.BLACK);
                } else if ((i == 0 && j == 1) || (i == 0 && j == 6)) {   // Black Knight
                    pieces[i][j] = new Knight(i, j, Color.BLACK);
                } else if ((i == 0 && j == 2) || (i == 0 && j == 5)) {   // Black Bishop
                    pieces[i][j] = new Bishop(i, j, Color.BLACK);
                } else if (i == 0 && j == 3) {   // Black Queen
                    pieces[i][j] = new Queen(i, j, Color.BLACK);
                } else if (i == 0 && j == 4) {   // Black King
                    pieces[i][j] = new King(i, j, Color.BLACK);
                } else if ((i == 7 && j == 0) || (i == 7 && j == 7)) {   // White Rock
                    pieces[i][j] = new Rock(i, j, Color.WHITE);
                } else if ((i == 7 && j == 1) || (i == 7 && j == 6)) {   // White Knight
                    pieces[i][j] = new Knight(i, j, Color.WHITE);
                } else if ((i == 7 && j == 2) || (i == 7 && j == 5)) {   // White Bishop
                    pieces[i][j] = new Bishop(i, j, Color.WHITE);
                } else if (i == 7 && j == 3) {   // White Queen
                    pieces[i][j] = new Queen(i, j, Color.WHITE);
                } else if (i == 7 && j == 4) {   // White King
                    pieces[i][j] = new King(i, j, Color.WHITE);
                } else if (i == 1) {
                    pieces[i][j] = new Pawn(i,j,Color.BLACK);
                } else if (i == 6) {
                    pieces[i][j] = new Pawn(i, j, Color.BLACK);
                }else {
                    pieces[i][j] = null;
                }
            }
        }
    }

    public void imprimirCasilla() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 7; j >= 0; j--) {
                System.out.print(pieces[i][j]);
            }
            System.out.println();
        }
    }

    public void pieceMovement(int initialRow, int initialColumn, int finalRow, int finalColumn) {
        pieceMoveInterface(pieces, initialRow, initialColumn, finalRow, finalColumn);
    }
}
