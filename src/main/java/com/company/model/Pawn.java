package com.company.model;

import com.company.api.ChessboardAPI;
import com.company.movements.IDiagonalMovement;
import com.company.movements.IHorizontalMovement;
import com.company.movements.IVerticalMovement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pawn extends Piece implements IVerticalMovement, IDiagonalMovement, IHorizontalMovement, ChessboardAPI {

    public Pawn(Color color) {
        super(color);
        this.setMaxDistance(2);
        this.setImage(color.equals(Color.BLACK) ? "src/main/java/images/blackPawn.png" : "src/main/java/images/whitePawn.png");
    }

    @Override
    public void calculatePossibleMovements(Locker[][] lockers, PositionOnBoard initialPosition) {
        List<PositionOnBoard> possibleDiagonalMovements;
        List<PositionOnBoard> possibleMovements;

        possibleDiagonalMovements = new ArrayList<>();
        possibleMovements = new ArrayList<>();

        if (getQuantityOfMovements() != 0) {

            this.setMaxDistance(1); // Modificamos la distancia máxima del peón una vez realizado el primer movimiento

            // Agregamos el movimiento diagonal para comer piezas
            possibleDiagonalMovements = possibleDiagonalMovements(lockers, initialPosition);

                // Eliminamos movimientos diagonales que no comen a otra pieza
            possibleDiagonalMovements.removeIf(positionOnBoard ->
                    lockers[positionOnBoard.getRow()][positionOnBoard.getColumn()].getPiece() instanceof EmptyPiece);
        }
        possibleMovements.addAll(possibleDiagonalMovements);

        //Agregamos el movimiento vertical
        possibleMovements = possibleVerticalMovements(lockers, initialPosition);

            //Eliminamos movimientos verticales que coman otra pieza
        possibleMovements.removeIf(positionOnBoard ->
                !(lockers[positionOnBoard.getRow()][positionOnBoard.getColumn()].getPiece() instanceof EmptyPiece));


        // Comprobamos la posibilidad de captura al paso en el caso del peón
        possibleMovements.add(enPassantCapture(lockers, initialPosition));

        this.setPossibleMovements(possibleMovements);
    }

    @Override
    public boolean checkMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        if (this.getColor() == (Color.BLACK)
                && finalPosition.getRow() - initialPosition.getRow() > 0) {
            return true;
        } else if (this.getColor() == (Color.WHITE)
                && finalPosition.getRow() - initialPosition.getRow() < 0) {
            return true;
        }
        return false;
    }

    private PositionOnBoard enPassantCapture(Locker[][] lockers,
                                             PositionOnBoard initialPosition) {
        List<PositionOnBoard> horizontalPositions;
        int availableRow;

        Piece sidePiece;

        horizontalPositions = possibleHorizontalMovements(lockers, initialPosition);
        horizontalPositions = horizontalPositions.stream().filter(PositionOnBoard -> {
            Piece piece = lockers[PositionOnBoard.getRow()][PositionOnBoard.getColumn()].getPiece();
            return (piece instanceof Pawn
                    && piece.getQuantityOfMovements() == 1
                    && ((Pawn) piece).getLastMovementRecord() == requestMovementRecord());
        }).collect(Collectors.toList());

        for (int i = 0; i < horizontalPositions.size(); i++) {
            sidePiece = lockers[horizontalPositions.get(i).getRow()][horizontalPositions.get(i).getRow()].getPiece();
            if (sidePiece.getQuantityOfMovements() == 1 && sidePiece instanceof Pawn) {
                availableRow = initialPosition.getRow() > 3 ? initialPosition.getRow() + 1 : initialPosition.getRow() - 1;
                return new PositionOnBoard(availableRow, horizontalPositions.get(i).getColumn());
            }
        }
        return new PositionOnBoard(-1, -1);
    }

    //TODO: Realizar solicitud para obtener el registro de los movimientos
    @Override
    public int requestMovementRecord() {
        return 3;
    }
}
