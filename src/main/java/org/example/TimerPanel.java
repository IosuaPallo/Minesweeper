package org.example;

import javax.swing.*;
import java.awt.*;



public class TimerPanel extends JPanel {
    Timer timer;
    public TimerPanel(){
       timer = new Timer();
    }

    public void setStop(){
        timer.setStop();
    }

    public void start(){
        timer.start();
    }

    public void paint(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawString(String.valueOf(timer.getSeconds()),0,0);
    }

}
