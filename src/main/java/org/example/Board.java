package org.example;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Random;

public class Board extends JPanel {
    private int numberPanelsWidth;
    private int numberPanelsHeight;
    private int minesNumber;
    private int minesRemaining;
    private int[][] map;
    private boolean[][] revealed;
    private Point[] neighbours;

    private Image[] images;

    private JPanel storagePanel, squaresPanel,resultPanel, resetPanel, timerPanel,minesRemainingPanel;

    private Button resetButton;

    private Timer timer;


    public Board(int width, int height, int minesNumber) {

        setSize(new Dimension(30*numberPanelsWidth+40, 30*numberPanelsHeight+150));
        this.numberPanelsWidth = width;
        this.numberPanelsHeight = height;
        this.minesNumber = minesNumber;
        this.minesRemaining = minesNumber;
        this.map = new int[height][width];
        this.revealed = new boolean[height][width];
        for (int i = 0; i < this.numberPanelsHeight; i++) {
            for (int j = 0; j < this.numberPanelsWidth; j++) {
                this.map[i][j] = 0;
                this.revealed[i][j] = false;
            }
        }
        this.setNeighbours();
        this.randomMines();
        timer = new Timer();
        images = new Image[13];
        for(int i=0;i<13;i++){
            String path = "Images/" + i + ".png";
            images[i] = new ImageIcon(path).getImage();
        }
        setUpBoard();
    }

    public void setUpBoard() {
        storagePanel = new JPanel(new GridLayout(1, 2));
        squaresPanel = new JPanel(new GridLayout(numberPanelsHeight, numberPanelsWidth));
        resetPanel = new JPanel();
        resultPanel = new JPanel();
        timerPanel = new JPanel();
        minesRemainingPanel = new JPanel();
        resetButton = new Button();

        resetButton.setBounds(0,0,resetPanel.getWidth(),resetPanel.getHeight());
        resetPanel.add(resetButton);

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        JLabel minesRemainingLabel = new JLabel(String.valueOf(this.minesRemaining));
        minesRemainingLabel.setFont(new Font("Arial", 0, 30));
        JLabel timeLabel = new JLabel(String.valueOf(timer.getSeconds()));
        timeLabel.setFont(new Font("Arial", 0, 30));

        timerPanel.add(timeLabel);
        minesRemainingPanel.add(minesRemainingLabel);

        storagePanel.add(minesRemainingPanel);
        storagePanel.add(timerPanel);

        storagePanel.setBorder(border);
        squaresPanel.setBorder(border);
        resetPanel.setBorder(border);
        resultPanel.setBorder(border);

        for (int i = 0; i < numberPanelsHeight; i++) {
            for (int j = 0; j < numberPanelsWidth; j++) {
                JLabel pictureLabel = new JLabel(new ImageIcon(images[10]));
                squaresPanel.add(pictureLabel);
            }
        }
        storagePanel.setBounds(10, 10, 30 * numberPanelsWidth, 50);
        squaresPanel.setBounds(10, 80, 30 * numberPanelsWidth, 30 * numberPanelsHeight);
        resetPanel.setBounds(10, squaresPanel.getY(), 30 * numberPanelsWidth, 50);
        resultPanel.setBounds(10, resetPanel.getY(), 30 * numberPanelsWidth, 50);

        add(storagePanel);
        add(squaresPanel);
        add(resetPanel);
        add(resultPanel);
    }

    private void randomMines() {
        Random random = new Random();
        for (int i = 0; i < this.minesNumber; i++) {
            int rowRandom = random.nextInt(numberPanelsHeight);
            int columnRandom = random.nextInt(numberPanelsWidth);
            this.map[rowRandom][columnRandom] = -1;
            for (int j = 0; j < 8; j++) {
                int row = rowRandom + this.neighbours[j].x;
                int column = columnRandom + this.neighbours[j].y;
                if(row>=0 && row <this.numberPanelsHeight) {
                    if(column>=0 && column<this.numberPanelsWidth) {
                        if(this.map[row][column]!=-1) {
                            this.map[row][column] += 1;
                        }
                    }
                }
            }
        }
    }
    private void setNeighbours() {
        this.neighbours = new Point[8];
        neighbours[0] = new Point(-1, -1);
        neighbours[1] = new Point(-1, 0);
        neighbours[2] = new Point(-1, 1);
        neighbours[3] = new Point(0, -1);
        neighbours[4] = new Point(0, 1);
        neighbours[5] = new Point(1, -1);
        neighbours[6] = new Point(1, 0);
        neighbours[7] = new Point(1, 1);
    }

    public void draw(){
        for(int i = 0; i<this.numberPanelsHeight; i++){
            for(int j = 0; j<this.numberPanelsWidth; j++){
                System.out.print(this.map[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
