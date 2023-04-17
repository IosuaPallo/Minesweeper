package org.example;

public class Timer extends Thread{
    private int seconds=0;

    public void resetTimer() {
        this.seconds = 0;
    }

    public void print(){
        System.out.println(this.seconds);
    }
    @Override
    public void run(){
        while(true){
            print();
            try {
                Thread.sleep(990);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            seconds++;
        }
    }
}
