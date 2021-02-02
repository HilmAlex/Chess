package com.company.model;

import com.company.movements.IMovement;

import java.awt.*;

public class ChessBoard implements IMovement {
    private String image = "";
    private Locker[][] lockers = new Locker[8][8];

    public ChessBoard() {
        startBoard();
        fillBoard();
    }

    private void fillBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i == 0 && j == 0) || (i == 0 && j == 7)) {   // Black Rock
                    lockers[i][j].setPiece(new Rock(Color.BLACK));
                } else if ((i == 0 && j == 1) || (i == 0 && j == 6)) {   // Black Knight
                    lockers[i][j].setPiece(new Knight(Color.BLACK));
                } else if ((i == 0 && j == 2) || (i == 0 && j == 5)) {   // Black Bishop
                    lockers[i][j].setPiece(new Bishop(Color.BLACK));
                } else if (i == 0 && j == 3) {   // Black Queen
                    lockers[i][j].setPiece(new Queen(Color.BLACK));
                } else if (i == 0 && j == 4) {   // Black King
                    lockers[i][j].setPiece(new King(Color.BLACK));
                } else if ((i == 7 && j == 0) || (i == 7 && j == 7)) {   // White Rock
                    lockers[i][j].setPiece(new Rock(Color.WHITE));
                } else if ((i == 7 && j == 1) || (i == 7 && j == 6)) {   // White Knight
                    lockers[i][j].setPiece(new Knight(Color.WHITE));
                } else if ((i == 7 && j == 2) || (i == 7 && j == 5)) {   // White Bishop
                    lockers[i][j].setPiece(new Bishop(Color.WHITE));
                } else if (i == 7 && j == 3) {   // White Queen
                    lockers[i][j].setPiece(new Queen(Color.WHITE));
                } else if (i == 7 && j == 4) {   // White King
                    lockers[i][j].setPiece(new King(Color.WHITE));
                } else if (i == 1) {
                    lockers[i][j].setPiece(new Pawn(Color.BLACK));
                } else if (i == 6) {
                    lockers[i][j].setPiece(new Pawn(Color.BLACK));
                }
            }
        }
    }


    private void startBoard() {
        for (int i = 0; i < lockers.length; i++) {
            for (int j = 0; j < lockers.length; j++) {
                if ((i + j) % 2 == 0) {
                    lockers[i][j] = new Locker(Color.WHITE, i, j, null);
                } else {
                    lockers[i][j] = new Locker(Color.BLACK, i, j, null);
                }
            }
        }

    }

    public void paint() {

    }

    public void imprimirCasilla() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 7; j >= 0; j--) {
                System.out.print(lockers[i][j]);
            }
            System.out.println();
        }
    }


}
