package com.company.views;

import com.company.model.*;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private ChessBoard chessBoard = new ChessBoard();
    private JLayeredPane panel1 = new JLayeredPane();

    public Window() throws HeadlessException {
        super("Chessboard");
        setSize(1000, 1000);
        setTitle("Chess");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(750, 800));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        panel1.setSize(900, 900);
        drawBoard();
        drawForm();
    }

    public void drawBoard() {
        JLabel board = new JLabel();
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Alex\\IdeaProjects\\Chess\\src\\main\\java\\images\\tablero.jpg");
        board.setBounds(50, 50, 550, 550);
        Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(board.getWidth(), board.getHeight(), Image.SCALE_DEFAULT));
        board.setIcon(icon);
        panel1.add(board, new Integer(1));
        fillPieces();
    }

    public void drawForm() {
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
                PieceView pieceView = new PieceView(chessBoard.getLockers()[i][j].getPiece());
                LockerView lockerView = new LockerView(x + 55 * i, y + 55 * j, pieceView);
                //panel1.add(lockerView,2);
                panel1.add(lockerView.getPieceView(),2);
            }
        }

    }
}
