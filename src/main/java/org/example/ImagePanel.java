package org.example;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private String path;

    public ImagePanel(String path){
        this.path=path;
    }

    public void paint(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
    }
}
