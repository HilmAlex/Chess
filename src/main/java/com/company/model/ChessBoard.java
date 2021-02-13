package com.company.model;

import com.company.movements.IMovement;
import lombok.Data;

import java.awt.*;
import java.util.*;
import java.util.List;

public @Data class ChessBoard implements IMovement {
    private String image = "C:\\Users\\Alex\\IdeaProjects\\Chess\\src\\main\\java\\images\\tablero.jpg";
    private Locker[][] lockers = new Locker[8][8];
    private List<String> movementRecord = new ArrayList<>();

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
        PositionOnBoard initialPosition;
        PositionOnBoard finalPosition;
        Piece piece;

        initialPosition = new PositionOnBoard(initialRow, initialColumn);
        finalPosition = new PositionOnBoard(finalRow, finalColumn);
        piece = lockers[initialRow][initialColumn].getPiece();

        if (checkPieceMove(initialPosition, finalPosition)) {
            lockers = pieceMoveInterface(lockers, initialPosition, finalPosition);
            movementRecord.add(piece.getLastMovementRecord() + " ");
            piece.setLastMovementRecord(movementRecord.size());
        } else {
            throw new Exception("Movimiento Ilegal");
        }
    }

    public boolean checkPieceMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        Locker initialLocker;
        Piece pieceToMove;
        initialLocker = lockers[initialPosition.getRow()][initialPosition.getColumn()];

        pieceToMove = initialLocker.getPiece();
        pieceToMove.calculatePossibleMovements(lockers, initialPosition);
        List<PositionOnBoard> possiblesMovements = pieceToMove.getPossibleMovements();

        if (pieceToMove.checkMove(initialPosition, finalPosition)) {
            //if (pieceToMove.getPossibleMovements().contains(finalPosition)) {
            for (int i = 0; i <possiblesMovements.size() ; i++) {
                if (possiblesMovements.get(i).getRow() == finalPosition.getRow()
                && possiblesMovements.get(i).getColumn() == finalPosition.getColumn()){
                    return true;
                }
            }
        }
        return false;
    }
}
