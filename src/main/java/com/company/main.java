package com.company;

import com.company.model.ChessBoard;
import com.company.views.Window;

public class main {
    public static void main(String[] args) throws Exception {
        ChessBoard chessBoard = new ChessBoard();

        Window window = new Window();
        window.setVisible(true);
    }
}
