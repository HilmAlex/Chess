package com.company.views;

import com.company.model.*;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private ChessBoard chessBoard;
    private JLayeredPane panel1 = new JLayeredPane();

    public Window() throws HeadlessException {
        super("Chessboard");
        setSize(1000, 1000);
        setTitle("Chess");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(750, 750));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        panel1.setSize(900, 900);
        drawBoard();
        drawForm();
        this.chessBoard = new ChessBoard();
    }

    public void drawBoard() {
        JLabel board = new JLabel();
        ImageIcon imageIcon = new ImageIcon("src/images/tablero.jpg");
        board.setBounds(50, 50, 550, 550);
        Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(board.getWidth(), board.getHeight(), Image.SCALE_DEFAULT));
        board.setIcon(icon);
        panel1.add(board, new Integer(1));
        fillPieces();
    }

    public void drawForm() {
    }

    // Diferencia de 55 en cada casilla
    public void addPiece(int x, int y, String image) {
        JLabel piece = new JLabel();
        ImageIcon imageIcon = new ImageIcon(image);
        piece.setBounds(x, y, 35, 35);
        Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(piece.getWidth(), piece.getHeight(), Image.SCALE_DEFAULT));
        piece.setIcon(icon);
        panel1.add(piece, new Integer(2));
    }

    public void fillPieces() {
        int x;
        int y;
        Locker[][] lockers;

        lockers = chessBoard.getLockers();
        x = 115;
        y = 115;

        for (int i = 0; i < lockers.length; i++) {
            for (int j = 0; j < lockers.length; j++) {
                //addPiece();
            }
        }
        
    }
}
