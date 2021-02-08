package com.company.movements;

import com.company.model.Locker;
import com.company.model.PositionOnBoard;

import java.awt.*;

public interface IDiagonalMovement {
    /**
     * Se verifica el movimiento diagonal utilizando la pendiente entre la posicion inicial
     * y la posible posicion final, si es igual a 1, el movimiento es diagonal.
     */
    default boolean checkDiagonalMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        if (Math.abs((finalPosition.getColumn() - initialPosition.getColumn())
                / (finalPosition.getRow() - initialPosition.getRow())) == 1) {
            return true;
        } else return false;
    }

    default Locker[][] possibleDiagonalMovements(Locker[][] lockers, PositionOnBoard initialPosition) {
        Locker[][] movements = new Locker[8][8];
        getDiagonalSquares(lockers, movements, initialPosition, (byte) 1, (byte) 1);
        getDiagonalSquares(lockers, movements, initialPosition, (byte) 1, (byte) -1);
        getDiagonalSquares(lockers, movements, initialPosition, (byte) -1, (byte) 1);
        getDiagonalSquares(lockers, movements, initialPosition, (byte) -1, (byte) -1);
        return movements;
    }

    /**
     * @param lockers           Casillas del tablero
     * @param movements         Arreglo de movimientos posibles basados en las casillas
     * @param initialPosition   Posicion Inicial de la casilla
     * @param horizontalTowards Lado horizontal hacia el que extrae los movimientos posibles,
     *                          "1" hacia la derecha y "-1" hacia la izquierda.
     * @param verticalTowards   Lado vertical hacia el que extrae los movimientos posibles,
     *                          1" hacia la arriba y "-1" hacia la abajo.
     */
    private void getDiagonalSquares(Locker[][] lockers, Locker[][] movements,
                                    PositionOnBoard initialPosition, byte horizontalTowards, byte verticalTowards) {
        Color colorPieceInitial = lockers[initialPosition.getRow()][initialPosition.getColumn()].getColor();
        int finalSquareBoard = horizontalTowards == 1 ? lockers.length - initialPosition.getRow() : initialPosition.getRow();
        ;
        for (int i = 1; i < finalSquareBoard + 1; i++) {

            int finalRowLocker = initialPosition.getRow() + i * (horizontalTowards);
            int finalColumnLocker = initialPosition.getColumn() + i * (verticalTowards);

            movements[finalRowLocker][finalColumnLocker] = lockers[finalRowLocker][finalColumnLocker];

            if (lockers[finalRowLocker][finalColumnLocker] != null) {
                if (lockers[finalRowLocker][finalColumnLocker].getPiece().getColor().equals(colorPieceInitial)) {
                    lockers[finalRowLocker][finalColumnLocker] = null;
                }
                break;
            }
        }
    }
}

