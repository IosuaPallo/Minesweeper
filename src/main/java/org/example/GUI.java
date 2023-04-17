package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI extends JFrame {

    BlockPanel  resetPanel;
    BlockPanel blocksPanel;
    Component[][] buttons;

    Button resetButton;

    int numberPanelsX, numberPanelsY;
    int numberRevealed;
    private boolean gameOver;
    GUI(int numberPanelsX, int numberPanelsY)  {
        this.numberPanelsX = numberPanelsX;
        this.numberPanelsY = numberPanelsY;

        resetPanel = new BlockPanel();
        resetButton = new Button();
    }

    public void setUpGUI() {
        blocksPanel = new BlockPanel(new GridLayout(numberPanelsY, numberPanelsX));
        buttons = new Button[numberPanelsY][numberPanelsX];
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        int number = 0, panelWidth, panelHeight;

        setTitle("Minesweeper");
        setSize(30 * numberPanelsX + 40, 30 * numberPanelsY + 120);

        blocksPanel.setBorder(border);

        Dimension windowSize = getSize();
        blocksPanel.setBounds(10, 10, 30 * numberPanelsX, 30 * numberPanelsY);
        for (int i = 0; i < numberPanelsY; i++) {
            for (int j = 0; j < numberPanelsX; j++) {
                buttons[i][j] = new Button();
                blocksPanel.add(buttons[i][j]);
            }
        }
        add(blocksPanel);


        resetPanel.add(resetButton);
        resetPanel.setBounds(10,30*numberPanelsY+10 , 30 * numberPanelsX, 60);
        resetPanel.setBorder(border);

        add(resetPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
