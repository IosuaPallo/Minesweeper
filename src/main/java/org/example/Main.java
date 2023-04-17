package org.example;

public class Main {
    public static void main(String[] args) {
        boolean gameOver = false;
        Timer timer = new Timer();
        //timer.run();
        GUI gui;
        String difficulty="easy";
        Board board;
        switch(difficulty){
            case "easy":
                board = new Board(9,9,10);
                gui = new GUI(9,9);
                break;
            case "intermediate":
                board = new Board(16,16,40);
                gui = new GUI(16,16);
                break;
            case "expert":
                board = new Board(30,16,99);
                gui = new GUI(30,16);
                break;
            default:
                gui = new GUI(5,5);
                break;
        }
        gui.setUpGUI();
        do{
            gui.repaint();
        }while(!gameOver);
        gameOver = true;
    }
}