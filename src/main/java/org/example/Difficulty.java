package org.example;

import java.util.ArrayList;
import java.util.List;

public class Difficulty {
    public ArrayList<Integer> setDifficulty(String dif){
        ArrayList<Integer> settings = new ArrayList<Integer>();
        switch(dif){
            case "easy":
                settings.add(0,9);
                settings.add(1,9);
                settings.add(2,10);
                break;
            case "intermediate":
                settings.add(0,16);
                settings.add(1,16);
                settings.add(2,40);
                break;
            case "expert":
                settings.add(0,30);
                settings.add(1,16);
                settings.add(2,99);
                break;
            default:
                settings.add(0,5);
                settings.add(1,5);
                settings.add(2,5);
                break;
        }
        return  settings;
    }
}
