package com.company.views;

import javax.swing.*;
import java.awt.*;

public class LockerView extends JLabel {
    private int width;
    private int height;
    private PieceView pieceView;

    public LockerView(int x, int y, PieceView pieceView) {
        this.pieceView = pieceView;
        this.width = 55;
        this.height = 55;
        drawPieceForm(x + 23, y + 23, width - 20, height - 20);
    }

    public void drawPieceForm(int x, int y, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(pieceView.getPiece().getImage());
        pieceView.setBounds(x, y, width, height);
        Icon icon = new ImageIcon(imageIcon
                .getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        pieceView.setIcon(icon);
    }

    public PieceView getPieceView() {
        return pieceView;
    }
}
