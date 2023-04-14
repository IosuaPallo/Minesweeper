package org.example;
import java.awt.Point;
import java.util.Random;

public class Board {
    private int boardWidth;
    private int boardHeight;
    private int minesNumber;
    private int[][] map;
    private Point[] neighbours;

    public Board(int width, int height, int minesNumber) {
        super();
        this.boardWidth = width;
        this.boardHeight = height;
        this.minesNumber = minesNumber;
        this.map = new int[height][width];
        for (int i = 0; i < this.boardHeight; i++) {
            for (int j = 0; j < this.boardWidth; j++) {
                this.map[i][j] = 0;
            }
        }
        this.setNeighbours();
        this.randomMines();
    }

    private void randomMines() {
        Random random = new Random();
        for (int i = 0; i < this.minesNumber; i++) {
            int rowRandom = random.nextInt(boardHeight);
            int columnRandom = random.nextInt(boardWidth);
            this.map[rowRandom][columnRandom] = -1;
            for (int j = 0; j < 8; j++) {
                int row = rowRandom + this.neighbours[j].x;
                int column = columnRandom + this.neighbours[j].y;
                if(row>=0 && row <this.boardHeight) {
                    if(column>=0 && column<this.boardWidth) {
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
        for(int i = 0; i<this.boardHeight; i++){
            for(int j = 0; j<this.boardWidth; j++){
                System.out.print(this.map[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
