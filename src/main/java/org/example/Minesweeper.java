package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Minesweeper extends JFrame {
    BoardPanel boardPanel;
    JPanel resetPanel;
    int numberPanelsX;
    int numberPanelsY;
    int numberMines;

    private JButton resetButton;
    public Minesweeper()  {
        this.setTitle("Minesweeper");
    }

    public void setupMinesweeper(int numberPanelsX, int numberPanelsY, int numberMines){
        if(boardPanel!=null){
            this.remove(boardPanel);
        }
        if (resetPanel!=null) {
            this.remove(boardPanel);
        }

        resetButton = new JButton();
        resetButton.setText("RESET");
        resetButton.addActionListener(new ResetButtonClick());

        this.numberPanelsX = numberPanelsX;
        this.numberPanelsY = numberPanelsY;
        this.numberMines = numberMines;

        resetButton.setPreferredSize(new Dimension(30*numberPanelsX,45));
        resetPanel = new JPanel();
        resetPanel.setPreferredSize(new Dimension(30*numberPanelsX,50));


        resetPanel.add(resetButton);



        this.setSize(30*numberPanelsX+60, 30*numberPanelsY+250);

        boardPanel = new BoardPanel();
        boardPanel.setUpBoardView(numberPanelsX,numberPanelsY,numberMines);

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        boardPanel.setBorder(border);
        resetPanel.setBorder(border);


        resetPanel.setBounds(10, 500, 30 * numberPanelsX+40, 50);
        boardPanel.setBounds(10, 10, 30 * numberPanelsX+40, 30 * numberPanelsY+200);

        this.add(boardPanel);
        this.add(resetPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private class ResetButtonClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setupMinesweeper(boardPanel.board.numberPanelsHeight, boardPanel.board.numberPanelsHeight, boardPanel.board.minesNumber);
        }
    }



}
