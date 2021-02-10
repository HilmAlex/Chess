package com.company.movements;

import com.company.model.Locker;
import com.company.model.PositionOnBoard;
import java.util.List;

/**
 * Esta interfaz determina los movimientos diagonales posibles de una pieza de ajedrez
 *      tomando en cuenta las limitaciones en cada pieza.
 * @author Alex Padilla
 */
public interface IDiagonalMovement extends IMovement {
    /**
     * Este método verifica si el movimiento es diagonal comparando la pendiente entre la posicion inicial
     *      y la posible posicion final, si esta es igual a 1, entonces el movimiento es diagonal.
     */
    default boolean checkDiagonalMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        if (Math.abs((finalPosition.getColumn() - initialPosition.getColumn())
                / (finalPosition.getRow() - initialPosition.getRow())) == 1) {
            return true;
        } else return false;
    }

    /**
     * Este metodo calcula los movimientos verticales posibles de una pieza de ajedrez, realiza un
     *  cálculo de movimientos ascendentes y descendentes a través del método getSquares() de la interfaz
     *  Imovement para luego unirlos en una sola lista.
     * @param lockers Casillas del tablero de ajedrez
     * @param initialPosition Posicion inicial de la pieza
     * @return Lista de posiciones posibles
     */
    default List<PositionOnBoard> possibleDiagonalMovements(Locker[][] lockers, PositionOnBoard initialPosition) {
        List<PositionOnBoard> possiblesMovements;
        possiblesMovements = getSquares(lockers, initialPosition, 1,1);
        possiblesMovements.addAll(getSquares(lockers,initialPosition, 1,-1));
        possiblesMovements.addAll(getSquares(lockers,initialPosition, -1,1));
        possiblesMovements.addAll(getSquares(lockers,initialPosition, -1,-1));
        return possiblesMovements;
    }

}

