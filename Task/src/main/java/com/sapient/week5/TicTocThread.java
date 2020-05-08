package com.sapient.week5;

import java.util.concurrent.Semaphore;

public class TicTocThread implements Runnable {
    private final boolean isTic;

    public TicTocThread(boolean isTic) {
        this.isTic = isTic;
    }

    static Semaphore ticLock = new Semaphore(1);
    static Semaphore tocLock = new Semaphore(0);

    @Override
    public void run() {
        if (isTic) {
            try {
                printTic();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                printToc();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printTic() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            ticLock.acquire(1);
            System.out.println("Tic");
            tocLock.release(1);
        }

    }

    private void printToc() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            tocLock.acquire(1);
            System.out.println("Toc");
            ticLock.release(1);
        }
    }
}
