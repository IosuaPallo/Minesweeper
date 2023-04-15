package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        boolean quitGame = false;
        GUI gui = new GUI(5,5);
        gui.setUpGUI();
        do{
            gui.window.repaint();
        }while(!quitGame);
        quitGame = true;
    }
}