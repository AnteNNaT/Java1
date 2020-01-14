package ru.geekbrains.java.lesson7;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    private int NumberOfLines;
    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;

    Map(){
        setBackground(Color.BLUE);
    }

    Map(int NumberOfLines) {
        this();
        NumberOfLines=this.NumberOfLines;

    }

    public void setNumberOfLines(int numberOfLines) {
        NumberOfLines = numberOfLines;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (NumberOfLines==0){return;}
        int cellWidth = getWidth() / NumberOfLines;
        int cellHeight = getHeight() / NumberOfLines;
        for (int i = 1; i < NumberOfLines; i++) {
            g.drawLine(i * cellWidth, 0, i * cellWidth, getHeight());
            g.drawLine(0, i * cellHeight, getWidth(), i * cellHeight);
        }
    }


    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        this.NumberOfLines=fieldSizeX;
        repaint();
        System.out.printf("mode = %d\nfsX = %d\nwin = %d", gameMode, fieldSizeX, winLength);

    }
}
