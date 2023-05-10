package ru.geekbrains;

import static java.lang.Thread.sleep;

public class Zadanie1 {
    public static void main(String[] args) {
        Zadanie1 zadanie1 = new Zadanie1();
        zadanie1.start();
    }

    private void start() {
        Thread t1 = new Thread(new Runner());
        t1.setName("ping");
        t1.start();
        Thread t2 = new Thread(new Runner());
        t2.setName("pong");
        t2.start();
    }


class Runner implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Message();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
    protected synchronized void Message() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        sleep(1000);
        notify();
        wait();
    }
}
