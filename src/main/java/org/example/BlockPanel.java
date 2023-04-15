package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlockPanel extends JLayeredPane  {
    private int width;
    private int height;

    private boolean tapped = false;
    BlockPanel(int width, int height){
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(80,80));
    }
    public void paint(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
        if(tapped == false) {
            graphics2D.drawRect(width, height, 80, 80);
        }
        else{
            graphics2D.drawRect(width,height,80,80);
        }
    }

}
