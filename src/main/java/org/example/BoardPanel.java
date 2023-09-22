package org.example;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;


public class BoardPanel extends JPanel {


    public int numberPanelsWidth;
    public int numberPanelsHeight;

    Board board;

    private JPanel storagePanel,resultPanel,minesRemainingPanel;

    private TimerPanel timerPanel;
    private SquaresPanel squaresPanel;

    private  JLabel minesRemainingLabel;


    public BoardPanel() {
        board = new Board();
        this.addMouseListener(new MineClick());
    }

    public void setUpBoardView(int width, int height, int minesNumber) {

        this.numberPanelsWidth = width;
        this.numberPanelsHeight = height;

        board.setUpBoard(width,height,minesNumber);


        storagePanel = new JPanel(new GridLayout(1, 2));
        resultPanel = new JPanel();
        minesRemainingPanel = new JPanel();
        squaresPanel = new SquaresPanel();
        timerPanel = new TimerPanel();

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        minesRemainingLabel = new JLabel(String.valueOf(this.board.minesRemaining));
        minesRemainingLabel.setFont(new Font("Arial", 0, 30));

        minesRemainingPanel.add(minesRemainingLabel);

        storagePanel.add(minesRemainingPanel);
        storagePanel.add(timerPanel);


        minesRemainingPanel.setBorder(border);
        timerPanel.setBorder(border);
        storagePanel.setBorder(border);
        squaresPanel.setBorder(border);
        resultPanel.setBorder(border);

        storagePanel.setPreferredSize(new Dimension(30 * numberPanelsWidth, 50));
        squaresPanel.setPreferredSize(new Dimension(30 * numberPanelsWidth , 30 * numberPanelsHeight));
        resultPanel.setPreferredSize(new Dimension(30 * numberPanelsWidth, 50));

        storagePanel.setBounds(10, 10, 30 * numberPanelsWidth, 50);
        squaresPanel.setBounds(10, 80, 30 * numberPanelsWidth, 30 * numberPanelsHeight);


        add(storagePanel);
        add(squaresPanel);
        add(resultPanel);

    }

    public class ResetButtonClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           setUpBoardView(numberPanelsWidth, numberPanelsHeight, board.minesNumber);
        }
    }

    private class MineClick extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent event) {
            if (!board.gameOver) {

                boolean paint = false;

                int width = event.getX() - 10;
                int height = event.getY() - 60;

                int i = height / 30;
                int j = width / 30;

                if (width < numberPanelsWidth * 30 && height < numberPanelsHeight * 30) {
                    if(!board.pressedFirst){
                        board.pressedFirst=true;
                        timerPanel.start();
                        timerPanel.repaint();
                    }
                    if (event.getButton() == MouseEvent.BUTTON3) {
                        paint = board.rightClick(i,j);

                    }
                    else {
                        paint = board.leftClick(i,j);

                    }
                    if (paint) {
                        minesRemainingLabel.setText(String.valueOf(board.minesRemaining));
                        repaint();
                    }
                }
            }
        }
    }

    public class SquaresPanel extends JPanel {
        protected int MINE = 9;
        protected int COVER=10;
        protected int MARK = 11;
        protected int WRONG_MARK=12;
        protected int COVER_MINE = MINE+COVER;
        protected int MARK_MINE = MARK + MINE;

        protected int MARK_MINE_COVER = MARK + MINE + COVER;
        Image[] images;
        public SquaresPanel() {
            images = new Image[13];
            for (int i = 0; i < 13; i++) {
                String path = "Images/" + i + ".png";
                images[i] = new ImageIcon(path).getImage();
            }
        }
        @Override
        public void setPreferredSize(Dimension dimension) {
            super.setPreferredSize(dimension);
        }
        @Override
        public void paintComponent(Graphics g) {
            int uncover = 0;

            for (int i = 0; i <board.map.length; i++) {

                for (int j = 0; j < board.map[i].length; j++) {

                    int cell = board.map[i][j];

                    if (!board.gameOver && cell == MINE) {
                        board.gameOver = true;
                    }
                    if (board.gameOver) {
                        if (cell == COVER_MINE) {
                            cell=MINE;
                        }else if (cell == MARK_MINE_COVER) {
                            cell = MARK;
                        } else if (cell > MARK_MINE) {
                            cell = WRONG_MARK;
                        } else if (cell > MINE) {
                            cell = COVER;
                        }
                    } else {
                        if (cell > COVER_MINE) {
                            cell = MARK;
                        } else if (cell > MINE) {
                            cell = COVER;
                            uncover++;
                        }
                    }
                    g.drawImage(images[cell], (j * 30),
                            (i * 30),30,30, this);
                }
            }

            if (uncover == 0 && !board.gameOver) {
                JLabel resultLabel = new JLabel("Win");
                resultPanel.add(resultLabel);
                board.gameOver=true;
            }
            else if (board.gameOver) {
                JLabel resultLabel = new JLabel("Lost");
                resultPanel.add(resultLabel);
            }
        }
    }


}
