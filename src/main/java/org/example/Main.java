package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        boolean quitGame = false;
        GUI gui = new GUI(4,4);
        gui.setUpGUI();
        do{
            gui.window.repaint();
            Thread.sleep(50);
        }while(!quitGame);
        quitGame = true;
    }
}