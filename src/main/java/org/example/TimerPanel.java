package org.example;

import javax.swing.*;
import java.awt.*;



public class TimerPanel extends JPanel {
    private int seconds;
    public TimerPanel(int seconds){
        this.seconds = seconds;
    }
    public void paint(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawString(String.valueOf(seconds),0,0);
    }

}
