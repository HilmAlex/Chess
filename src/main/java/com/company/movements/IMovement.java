package com.company.movements;

import com.company.model.*;

import java.util.Optional;

public interface IMovement {

    default Locker[][] pieceMoveInterface(
            Locker[][] lockers, PositionOnBoard initialPosition, PositionOnBoard finalPosition) {

        // Asigna la casilla inicial y casilla final a una variable
        Locker initialLocker = lockers[initialPosition.getRow()][initialPosition.getColumn()];
        Locker finalLocker = lockers[finalPosition.getRow()][finalPosition.getColumn()];
        Piece piece = lockers[initialPosition.getRow()][initialPosition.getColumn()].getPiece();

        // Comprobamos que la casilla tenga una pieza no vacía y realizamos el cambio de pieza
        if (!(piece instanceof EmptyPiece)) {
            finalLocker.setPiece(initialLocker.getPiece());
            initialLocker.setPiece(new EmptyPiece());

            // Modificamos la distancia máxima del el peón una vez realizado el primer movimiento
            if (piece instanceof Pawn) {
                piece.setMaxDistance(1);
            }
        }

        return lockers;
    }
}
