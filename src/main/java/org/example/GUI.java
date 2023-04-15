package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI {

    public JFrame window;
    BlockPanel[][] panels;
    
    JPanel panelsV2;
    int numberPanelsX, numberPanelsY;
    int numberRevealed;
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
                panelWidth = 20 + 80 * j;
                panelHeight = 20 + 80 * i;
                panels[i][j] = new BlockPanel(panelWidth, panelHeight);
                panels[i][j].setBackground(Color.ORANGE);
                panels[i][j].setForeground(Color.RED);
                panels[i][j].setBorder(border);
                window.add(panels[i][j]);
            }
        }
        window.add(panelsV2);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}
