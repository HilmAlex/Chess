package com.company.model;

import com.company.views.Window;

public class Game {
    private Window window;
    private ChessBoard chessBoard;
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.window = new Window();
        this.chessBoard = new ChessBoard();
        this.player1 = player1;
        this.player2 = player2;
    }

    public void move(){

    }
}
