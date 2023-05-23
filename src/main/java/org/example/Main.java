package org.example;

import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String difficulty="easy";
        ArrayList<Integer>settings =  new Difficulty().setDifficulty(difficulty);
        EventQueue.invokeLater(() -> {
            Minesweeper minesweeper = new Minesweeper();
            minesweeper.setupMinesweeper(settings.get(0), settings.get(1), settings.get(2));
            minesweeper.setVisible(true);
        });
    }
}