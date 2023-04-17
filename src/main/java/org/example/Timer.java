package org.example;

public class Timer extends Thread{
    private int seconds;

    public Timer(){
        this.seconds=0;
    }

    public void resetTimer() {
        this.seconds = 0;
    }
    public int getSeconds(){
        return this.seconds;
    }


    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(990);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            seconds++;
        }
    }
}
