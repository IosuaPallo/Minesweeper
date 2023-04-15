package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI {

    public JFrame window;
    BlockPanel[][] panels;
    Button[][] buttons;

    Button resetButton;

    JPanel jobsPanel;
    JPanel blocksPanel;
    int numberPanelsX, numberPanelsY;
    int numberRevealed;
    GUI(int numberPanelsX, int numberPanelsY)  {
        this.numberPanelsX = numberPanelsX;
        this.numberPanelsY = numberPanelsY;
        panels = new BlockPanel[numberPanelsY][numberPanelsX];


        blocksPanel = new JPanel(new GridLayout(numberPanelsY,numberPanelsX));
        window = new JFrame();
        buttons = new Button[numberPanelsY][numberPanelsX];
        jobsPanel = new JPanel(new GridLayout(1,3));
        resetButton = new Button();
    }

    public void setUpGUI(){
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        int number = 0, panelWidth,panelHeight;

        window.setSize(50*numberPanelsX+10, 51*numberPanelsY+90);

        jobsPanel.setBorder(border);
        jobsPanel.setBounds(0,0,50*numberPanelsX,50);
        jobsPanel.add(new Button());
        jobsPanel.add(resetButton);
        jobsPanel.add(new Button());

        blocksPanel.setBounds(0,50,50*numberPanelsX, 50*numberPanelsY);
        for(int i=0;i<numberPanelsY;i++) {
            for (int j = 0; j < numberPanelsX; j++) {
                buttons[i][j] = new Button();
                blocksPanel.add(buttons[i][j]);
            }
        }

        window.add(blocksPanel);
        window.add(jobsPanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}
