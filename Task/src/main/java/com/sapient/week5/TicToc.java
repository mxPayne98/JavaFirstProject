package com.sapient.week5;

public class TicToc {

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new TicTocThread(true));
        Thread b = new Thread(new TicTocThread(false));
        a.start();
        b.start();

        a.join();
        b.join();
    }
}
