package ru.geekbrains;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Zadanie2 {
    private Lock lock = new ReentrantLock();
    private long count = 0;

    public static void main(String[] args) {

        Zadanie2 zadanie2 = new Zadanie2();
        zadanie2.start();

    }

    private void inc() throws InterruptedException {
        try {
            lock.lock();
            this.count++;
            System.out.println(Thread.currentThread().getName() + " " + count);
            sleep(1000);
        } finally {
            lock.unlock();
        }
    }

    private void start() {
        Thread t1 = new Thread(new Count());
        Thread t2 = new Thread(new Count());
        Thread t3 = new Thread(new Count());
        t1.start();
        t2.start();
        t3.start();
    }

    class Count implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    inc();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
