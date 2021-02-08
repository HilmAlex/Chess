package com.company.model;

import com.company.movements.IMovement;

import java.awt.*;
import java.util.*;
import java.util.List;

public class ChessBoard implements IMovement {
    private String image = "C:\\Users\\Alex\\IdeaProjects\\Chess\\src\\main\\java\\images\\tablero.jpg";
    private Locker[][] lockers = new Locker[8][8];

    public Locker[][] getLockers() {
        return lockers;
    }

    public ChessBoard(int i){
        startBoard();
    }

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
                    lockers[i][j].setPiece(new Pawn(Color.WHITE));
                } else {
                    lockers[i][j].setPiece(new EmptyPiece());
                }
            }
        }
    }

    private void startBoard() {
        for (int i = 0; i < lockers.length; i++) {
            for (int j = 0; j < lockers.length; j++) {
                if ((i + j) % 2 == 0) {
                    lockers[i][j] = new Locker(Color.WHITE, i, j);
                } else {
                    lockers[i][j] = new Locker(Color.BLACK, i, j);
                }
            }
        }

    }

    public void setPiece(int row, int column, Piece piece) {
        lockers[row][column].setPiece(piece);
    }

    public Piece getPiece(int row, int column){
        return lockers[row][column].getPiece();
    }

    public void imprimirCasilla() {
        Optional<Locker> locker;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                locker = Optional.ofNullable(lockers[i][j]);
                if (locker.isEmpty()) {
                    System.out.print("vacio       ");
                } else {
                    System.out.print(lockers[i][j].getPiece() + "        ");
                }
            }
            System.out.println();
        }
    }

    public void movePiece(int initialRow, int initialColumn, int finalRow, int finalColumn) throws Exception {
        PositionOnBoard initialPosition = new PositionOnBoard(initialRow, initialColumn);
        PositionOnBoard finalPosition = new PositionOnBoard(finalRow, finalColumn);

        if (checkPieceMove(initialPosition, finalPosition)) {
            lockers = pieceMoveInterface(lockers, initialPosition, finalPosition);
        } else {
            throw new Exception("Movimiento Ilegal");
        }
    }

    public boolean checkPieceMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        Locker initialLocker= lockers[initialPosition.getRow()][initialPosition.getColumn()];
        Locker finalLocker = lockers[finalPosition.getRow()][finalPosition.getColumn()];
        Piece pieceToMove = initialLocker.getPiece();
        List<PositionOnBoard> possiblesMovements= pieceToMove.possibleMovements(lockers, initialLocker.getPosition());

        if (pieceToMove.checkMove(initialPosition, finalPosition)){
            if(possiblesMovements.contains(finalLocker.getPosition())){
                return true;
            }
        }
        return false;
    }

    public void rotateMatrix() {
        Locker[][] newLocker = lockers;
        int k = 7;
        int l = 7;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                lockers[i][j] = newLocker[k][j--];
            }
            k--;
        }
    }
}
