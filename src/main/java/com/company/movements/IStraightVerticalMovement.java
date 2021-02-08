package com.company.movements;

import com.company.model.EmptyPiece;
import com.company.model.Locker;
import com.company.model.PositionOnBoard;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;

/**
 * Esta interfaz determina los movimientos verticales posibles de una pieza de ajedrez
 *      tomando en cuenta las limitaciones en cada pieza.
 * @author Alex Padilla
 */

public interface IStraightVerticalMovement {

    /**
     * Este método verifica que el movimiento de una pieza sea vertical, si la fila inicial
     *      es igual a la fila inicial, entonces la pieza realizó un movimiento vertical
     * @param initialPosition Posicion inicial de la pieza
     * @param finalPosition Posicion final de la pieza
     * @return Valor booleano que determina si el movimiento es vertical
     */
    default boolean checkStraightVerticalMove(PositionOnBoard initialPosition, PositionOnBoard finalPosition) {
        if (initialPosition.getRow() == finalPosition.getRow()
                || (initialPosition.getColumn() == finalPosition.getColumn())) {
            return true;
        } else return false;
    }

    /**
     * Este metodo calcula los movimientos verticales posibles de una pieza de ajedrez, realiza un
     *  cálculo de movimientos ascendentes y descendentes a través del método getVerticalSquares()
     *  para luego unirlos en una sola lista.
     * @param lockers Casillas del tablero de ajedrez
     * @param initialPosition Posicion inicial de la pieza
     * @return Lista de posiciones posbiles
     */
    default List<PositionOnBoard> possibleStraightVerticalMovements(Locker[][] lockers, PositionOnBoard initialPosition) {
        List<PositionOnBoard> possiblesMovements;
        possiblesMovements = getVerticalSquares(lockers, initialPosition, 1);
        possiblesMovements.addAll(getVerticalSquares(lockers,initialPosition, -1));
        return possiblesMovements;
    }

    /**
     * getVerticalSquares(): Determina los movimientos verticales posibles de una pieza, recorre
     *      las casillas del tablero en la dirección asignada hasta encontrar un límite, este puede
     *      ser el final del tablero, la posición de una pieza de diferente color (comer pieza) o
     *      la posición anterior a una pieza del mismo color.
     * @param lockers         Casillas del tablero
     * @param initialPosition Posicion Inicial de la casilla
     * @param verticalTowards Lado vertical hacia el que extrae los movimientos posibles,
     *                        1" hacia la arriba y "-1" hacia la abajo.
     */
    default List<PositionOnBoard> getVerticalSquares(Locker[][] lockers,
                                                     PositionOnBoard initialPosition,
                                                     int verticalTowards) {
        // Declaración de variables
        Color colorPieceInitial;
        int maxiumSquares;
        List<PositionOnBoard> possiblesMovements = new ArrayList<>();
        Locker initialLocker = lockers[initialPosition.getRow()][initialPosition.getColumn()];
        Locker variableFinalLocker;

        // Se define el color inicial de la pieza en la casilla
        colorPieceInitial = initialLocker.getPiece().getColor();

        /** Si la verticalidad se positiva, la cantidad de movimientos hasta llegar al final del tablero
         *      será la resta entre el tamaño del tablero y la fila inicial menos 1; si es negativa, será
         *      la fila inicial
        */
        if (verticalTowards > 0) {
            maxiumSquares = lockers.length - initialPosition.getRow() - 1;
        } else {
            maxiumSquares = initialPosition.getRow();
        }

        /** Se toma la cantidad máxima de casillas a recorrer como el mínimo entre el final del tablero
         *      y la distancia máxima de la pieza
         */
        maxiumSquares = Math.min(maxiumSquares, initialLocker.getPiece().getMaxDistance());

        //Recorre las casillas verticales
        for (int i = 1; i <= maxiumSquares; i++) {

            variableFinalLocker = lockers[initialPosition.getRow() + i * (verticalTowards)][initialPosition.getColumn()];

            //Si la pieza de la casilla final está vacía, agrega la posición a la lista
            if (variableFinalLocker.getPiece() instanceof EmptyPiece) {
                possiblesMovements.add(variableFinalLocker.getPosition());
            }
            // Si la pieza de la casilla final es de igual color que la pieza inicial, se termina la ejecución
            else if (variableFinalLocker.getPiece().getColor().equals(colorPieceInitial)) {
                break;
            }
            // Si la pieza de la casilla final es de diferente color que que la pieza inicial, se agrega la posicion
            //    a la lista y se termina la ejecución
            else {
                possiblesMovements.add(variableFinalLocker.getPosition());
                break;
            }
        }
        return possiblesMovements;
    }
}

