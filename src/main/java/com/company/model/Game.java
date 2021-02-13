package com.company.model;

import com.company.views.Window;
import lombok.Data;

import java.awt.*;

public @Data class Game {
    //private Window window;
    private ChessBoard chessBoard;
    private Player whitePlayer;
    private Player blackPlayer;
    private boolean definedColors;

    public Game(Player player1, Player player2) {
        //this.window = new Window();
        this.chessBoard = new ChessBoard();
        this.whitePlayer = player1;
        this.blackPlayer = player2;
        this.definedColors = false;
    }

    public void setColor(Player player, Color color) {
        if (! definedColors){
            if (!(whitePlayer == player && color.equals(Color.WHITE))) {
                changePlayerColor(whitePlayer, this.blackPlayer);
                this.definedColors = true;
            }
        }
    }

    public void changePlayerColor(Player player1, Player player2) {
        Player auxPlayer;

        auxPlayer = player1;
        player1 = player2;
        player2 = auxPlayer;
    }

    public void setColor() {
        Color randomColor;

        randomColor = (int) (Math.random() + 1) == 0 ? Color.WHITE : Color.BLACK;

        setColor(this.whitePlayer, randomColor);
    }

    public boolean move(Player player) {
        return definedColors;
    }
}
