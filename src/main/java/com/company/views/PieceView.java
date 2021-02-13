package com.company.views;

import com.company.model.Piece;

import javax.swing.*;
import java.awt.*;

public class PieceView extends JLabel{
    private Piece piece;

    public PieceView(Piece piece) {
        this.piece = piece;
    }
    public Piece getPiece() {
        return piece;
    }
}
