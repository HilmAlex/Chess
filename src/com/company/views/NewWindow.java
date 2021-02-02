package com.company.views;

import javax.swing.*;

public class NewWindow extends JFrame{
    JPanel jPanel;

    public NewWindow(){
        jPanel = new JPanel();
        ImageIcon imageIcon = new ImageIcon("chessboard.jpg");
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        jPanel.add(jLabel);
        setContentPane(jPanel);
        this.setVisible(true);
    }
}
