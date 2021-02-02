package com.company.views;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private JPanel panel1;

    public Window() throws HeadlessException {
        super("Chessboard");

        setSize(1000,1000);
        setTitle("Chess");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(650,650));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1.setSize(900, 900);
        setContentPane(panel1);
        drawBoard();
        drawForm();
    }
    public void drawBoard(){
        JLabel board = new JLabel();
        ImageIcon imageIcon = new ImageIcon("chessboard.jpg");
        board.setBounds(0,0, 650, 650);
        Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(board.getWidth(),board.getHeight(),Image.SCALE_DEFAULT));
        board.setIcon(icon);
        panel1.add(board);
    }

    public void drawForm(){
        JTextField row = new JTextField();
        row.setSize(100,20);
        row.setLocation(0,0);
        JTextField column = new JTextField();
        column.setSize(100,20);
        column.setLocation(150,0);
        panel1.add(row);
        panel1.add(column);
    }

    public void paint(Graphics graphics){
        Dimension size = this.getSize();
        ImageIcon image = new ImageIcon("chessboard.jpg");
        graphics.drawImage(image.getImage(), 0, 0, size.width, size.height, null);

        super.paint(graphics);
    }
}
