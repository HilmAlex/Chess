package com.company.movements;

import com.company.model.*;
import com.sun.jdi.InterfaceType;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public interface IMovement {

    /**
     * Cambia la posición de una pieza, a la casilla de la posición final se le asigna la pieza de la casilla inicial,
     * y a la casilla inicial se le asigna una pieza vacía
     *
     * @param lockers         Casillas del tablero de ajedrez
     * @param initialPosition Posición inicial de la casilla que contiene a la pieza a mover
     * @param finalPosition   Posicion final de la casilla a la que se mueve la pieza
     * @return
     */
    default Locker[][] pieceMoveInterface(
            Locker[][] lockers, PositionOnBoard initialPosition, PositionOnBoard finalPosition) {

        // Asigna la casilla inicial y casilla final a una variable
        Locker initialLocker = lockers[initialPosition.getRow()][initialPosition.getColumn()];
        Locker finalLocker = lockers[finalPosition.getRow()][finalPosition.getColumn()];
        Piece piece = initialLocker.getPiece();

        // Comprobamos que la casilla inicial no tenga una pieza vacía y realizamos el cambio
        if (!(piece instanceof EmptyPiece)) {
            // Se incrementa el contador de movimientos de la pieza
            piece.increaseMovement();
            //Se hace el intercambio
            finalLocker.setPiece(piece);
            initialLocker.setPiece(new EmptyPiece());

        }
        return lockers;
    }

    /**
     * getSquares(): Determina los movimientos verticales posibles de una pieza, recorre
     * las casillas del tablero en la dirección asignada hasta encontrar un límite, este puede
     * ser el final del tablero, la posición de una pieza de diferente color (comer pieza) o
     * la posición anterior a una pieza del mismo color.
     *
     * @param lockers             Casillas del tablero
     * @param initialPosition     Posicion Inicial de la casilla
     * @param verticallyTowards   Lado hacia el que extrae los movimientos posibles, "1" hacia arriba,
     *                            "-1" hacia abajo y 0 únicamente vertical.
     * @param horizontallyTowards Lado hacia el que extrae los movimientos posibles, "1" hacia la derecha ,
     *                            "-1" hacia la izquierda y 0 únicamente horizontal.
     */
    default List<PositionOnBoard> getSquares(Locker[][] lockers,
                                             PositionOnBoard initialPosition,
                                             int verticallyTowards, int horizontallyTowards) {
        // Declaración de variables
        Color colorPieceInitial;
        int maxiumSquares;
        int verticalMaximumSquares = 0;
        int horizontalMaximumSquares = 0;

        List<PositionOnBoard> possiblesMovements = new ArrayList<>();
        Locker initialLocker = lockers[initialPosition.getRow()][initialPosition.getColumn()];
        Locker variableFinalLocker;

        // Se define el color inicial de la pieza en la casilla
        colorPieceInitial = initialLocker.getPiece().getColor();

        /** Si la verticalidad es positiva, la cantidad de movimientos hasta llegar al final del tablero
         *      será la resta entre el tamaño del tablero y la fila inicial menos 1; si es negativa, será
         *      la fila inicial
         */

        if (verticallyTowards > 0) {
            verticalMaximumSquares = lockers.length - initialPosition.getRow() - 1;
        } else if (verticallyTowards < 0) {
            verticalMaximumSquares = initialPosition.getRow();
        }

        /** Si la horizontalidad es positiva, la cantidad de movimientos hasta llegar al final del tablero
         *      será la resta entre el tamaño del tablero y la fila inicial menos 1; si es negativa, será
         *      la fila inicial
         */

        if (horizontallyTowards > 0) {
            horizontalMaximumSquares = initialPosition.getColumn();
        } else if (horizontallyTowards < 0) {
            horizontalMaximumSquares = lockers.length - initialPosition.getColumn() - 1;
        }

        if (horizontallyTowards == 0) {
            maxiumSquares = verticalMaximumSquares;
        } else if (verticallyTowards == 0){
            maxiumSquares = horizontalMaximumSquares;
        }else {
            maxiumSquares = Math.min(verticalMaximumSquares, horizontalMaximumSquares);
        }

        /** Se toma la cantidad máxima de casillas a recorrer como el mínimo entre la distancia al
         * final del tablero y la distancia máxima que puede recorrer la pieza
         */
        maxiumSquares = Math.min(maxiumSquares, initialLocker.getPiece().getMaxDistance());

        //Recorre las casillas según la horizontalidad (horizontallyTowards) y verticalidad(verticallyTowards)
        for (int i = 1; i <= maxiumSquares; i++) {

            variableFinalLocker = lockers[initialPosition.getRow() + i * verticallyTowards]
                    [initialPosition.getColumn() - i * horizontallyTowards];

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

