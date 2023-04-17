package org.example;

import javax.swing.*;
import java.awt.*;

public class Minesweeper extends JFrame {
    int numberPanelsX, numberPanelsY;
    int numberRevealed;
    private boolean gameOver;

    Board board;
    public Minesweeper(int numberPanelsX, int numberPanelsY, int numberMines)  {
        this.numberPanelsX = numberPanelsX;
        this.numberPanelsY = numberPanelsY;
        board = new Board(numberPanelsX,numberPanelsY,numberMines);
    }

    public void setUpMinesweeper() {
        this.setSize(30*numberPanelsX+40, 30*numberPanelsY+150);

        this.add(board);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


}
