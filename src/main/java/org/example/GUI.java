package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI {

    JFrame window;
    BlockPanel[][] panels;
    JPanel panelsV2;
    int numberPanelsX, numberPanelsY;
    GUI(int numberPanelsX, int numberPanelsY)  {
        this.numberPanelsX = numberPanelsX;
        this.numberPanelsY = numberPanelsY;
        panels = new BlockPanel[numberPanelsY][numberPanelsX];
        panelsV2 = new JPanel(new GridLayout(numberPanelsX,numberPanelsY));
        window = new JFrame();
    }

    public void setUpGUI(){
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        int number = 0, panelWidth,panelHeight;

        window.setSize(100*numberPanelsX+50, 100*numberPanelsY+50);

        for(int i=0;i<numberPanelsY;i++) {
            for (int j = 0; j < numberPanelsX; j++) {
                panelWidth = 20 + 40 * j;
                panelHeight = 20 + 40 * i;
                panels[i][j] = new BlockPanel(panelWidth, panelHeight);
              /* *//* JLabel label = new JLabel("Panel " + number++);
                label.setBounds(panelWidth,panelHeight, panelWidth+30, panelHeight+30);*//*
                panels[i][j].add(label);*/
                panels[i][j].setBackground(Color.ORANGE);
                panels[i][j].setBounds(panelWidth, panelHeight, 100, 100);
                panels[i][j].setBorder(border);
                window.add(panels[i][j]);
            }
        }
       /* panelsV2.setBackground(Color.ORANGE);
        panelsV2.setBorder(border);*/
        window.add(panelsV2);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}
