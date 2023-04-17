package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlockPanel extends JPanel  {
    public BlockPanel(){
        super();
    }

    public BlockPanel(int xCoord, int yCoord){
        setPreferredSize(new Dimension(30,30));
    }

    public BlockPanel(LayoutManager layout){
        super(layout);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
    }

}
