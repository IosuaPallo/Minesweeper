package org.example;

public class Main {
    public static void main(String[] args) {
        boolean gameOver = false;
        //timer.run();
        Minesweeper minesweeper;
        String difficulty="easy";
        switch(difficulty){
            case "easy":
                minesweeper = new Minesweeper(9,9,10);
                break;
            case "intermediate":
                minesweeper = new Minesweeper(16,16,40);
                break;
            case "expert":
                minesweeper = new Minesweeper(30,16,99);
                break;
            default:
                minesweeper = new Minesweeper(5,5,5);
                break;
        }
        minesweeper.setUpMinesweeper();
        minesweeper.board.draw();
        do{
            minesweeper.repaint();
        }while(!gameOver);
        gameOver = true;
    }
}