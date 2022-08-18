package com.company.homework.homework11;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    static ReentrantLock[] forks = {new ReentrantLock(), new ReentrantLock(), new ReentrantLock(), new ReentrantLock(),
            new ReentrantLock()};

    public static void main(String[] args) {

        new Thread(new Philosopher("1", forks[0], forks[1])).start();
        new Thread(new Philosopher("2", forks[1], forks[2])).start();
        new Thread(new Philosopher("3", forks[2], forks[3])).start();
        new Thread(new Philosopher("4", forks[3], forks[4])).start();
        new Thread(new Philosopher("5", forks[4], forks[0])).start();
    }
}
