package org.example;

import javax.swing.*;
import java.awt.*;

public class Timer extends Thread {
    private int seconds;
    private boolean stop=true;
    public Timer(){
        this.seconds=0;
    }

    public Timer setStop() {
        this.stop = true;
        return this;
    }

    public void resetTimer() {
        this.seconds = 0;
    }
    public int getSeconds(){
        return this.seconds;
    }


    @Override
    public void run() {
        seconds=0;
        stop=false;
        while (!stop) {
            try {
                Thread.sleep(998);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            seconds++;
        }
    }


}
