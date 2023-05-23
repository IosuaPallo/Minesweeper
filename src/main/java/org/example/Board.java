package org.example;

import java.awt.*;
import java.util.Random;

public class Board {
    public int MINE = 9;
    public int COVER=10;
    public int MARK = 11;
    public int WRONG_MARK=12;
    public int COVER_MINE = MINE+COVER;
    public int MARK_MINE = MARK + MINE;

    public int numberPanelsWidth;
    public int minesNumber;
    public int numberPanelsHeight;
    public int minesRemaining;
    public int[][] map;
    public Point[] neighbours;

    public Timer timer;


    public boolean gameOver;
    public boolean pressedFirst;

    Board(){

        this.setNeighbours();
        timer = new Timer();
    }

    public void setUpBoard(int width, int height, int minesNumber){

        this.map = new int[height][width];
        this.numberPanelsWidth = width;
        this.numberPanelsHeight = height;
        this.minesNumber = minesNumber;
        this.minesRemaining = minesNumber;

        for (int i = 0; i < this.numberPanelsHeight; i++) {
            for (int j = 0; j < this.numberPanelsWidth; j++) {
                this.map[i][j] = COVER;
            }
        }

        timer.resetTimer();
        this.randomMines();

        gameOver=false;
        pressedFirst = false;
    }

    private void randomMines() {
        Random random = new Random();
        for (int i = 0; i < this.minesNumber; i++) {
            int rowRandom = random.nextInt(numberPanelsHeight);
            int columnRandom = random.nextInt(numberPanelsWidth);
            while(map[rowRandom][columnRandom]==COVER_MINE){
                rowRandom = random.nextInt(numberPanelsHeight);
                columnRandom = random.nextInt(numberPanelsWidth);
            }
            this.map[rowRandom][columnRandom] = COVER_MINE;
            for (int j = 0; j < 8; j++) {
                int row = rowRandom + this.neighbours[j].x;
                int column = columnRandom + this.neighbours[j].y;
                if(row>=0 && row <this.numberPanelsHeight) {
                    if(column>=0 && column<this.numberPanelsWidth) {
                        if(this.map[row][column]!=MINE && this.map[row][column]!=COVER_MINE) {
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

    private void findEmpty(int i, int j){
        for(int k=0;k<neighbours.length;k++){
            int row = i+neighbours[k].x;
            int col = j + neighbours[k].y;
            if((row>=0 && row<numberPanelsHeight)&& (col>=0 && col<numberPanelsWidth)){
                if(map[row][col]>MINE){
                    map[row][col]-=COVER;
                    if(map[row][col] == 0){
                        findEmpty(row,col);
                    }
                }
            }
        }
    }


    public boolean rightClick(int i, int j){
        if (! pressedFirst) {
            pressedFirst = true;
            timer.start();
        }
        if((i>=0 && i<numberPanelsHeight) &&(j>=0 && j<numberPanelsWidth) ) {
            if (map[i][j] > MINE) {
                if (map[i][j] <= COVER_MINE) {
                    if (minesRemaining > 0) {
                        map[i][j] += MARK;
                        minesRemaining--;
                    }
                } else {
                    map[i][j] -= MARK;
                    minesRemaining++;
                }
                return true;
            }
        }
        return false;
    }

    public boolean leftClick(int i,int j){
        if (!pressedFirst) {
            pressedFirst = true;
            timer.start();
        }
        if((i>=0 && i<numberPanelsHeight) &&(j>=0 && j<numberPanelsWidth) ) {
            if (map[i][j] > COVER_MINE) {
                return false;
            }
            if (map[i][j] > MINE && map[i][j] < MARK_MINE) {
                map[i][j] -= COVER;
                if (map[i][j] == MINE) {
                    timer.setStop();
                    gameOver = true;
                }
                if (map[i][j] == 0) {
                    findEmpty(i, j);
                }
                return true;
            }
        }
        return false;
    }
}
