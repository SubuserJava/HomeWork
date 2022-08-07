package com.company.homework.homework11;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable {

    int id;
    ReentrantLock leftFork;
    ReentrantLock rightFork;

    public Philosopher(int id) {
        this.id = id;

    }

    @Override
    public void run() {
        int timeThinking;
        int timeEating;
        do {
            try {
                rightFork = Forks.forks[id];
                leftFork = Forks.forks[(id + 1) % 5];

//                rightFork.lock();
//                leftFork.lock();


                if (!rightFork.isLocked()) {
                    rightFork.lock();
                    timeThinking = timeThinking();
                    System.out.printf("Philosopher %s take right fork. Fork is one. Thinking %s sec...\n", id, timeThinking / 1000);
                    Thread.sleep(timeThinking);
                    if (!leftFork.isLocked()) {
                        leftFork.lock();
                        timeEating = timeEating();
                        System.out.printf("Philosopher %s took two forks. Eating %s sec...\n", id, (timeEating() / 1000));
                        Thread.sleep(timeEating);
                    } else {

                    }
                } else {

                }


                    leftFork.unlock();
                    rightFork.unlock();


                timeThinking = timeThinking();
                System.out.printf("The philosopher %s ate and put the forks. Thinking %s sec...\n", id, (timeThinking / 1000));
                Thread.sleep(timeThinking);

            } catch (IllegalMonitorStateException | InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public int timeEating() {
        return 1000 * ((new Random().nextInt(10) + 1));
    }

    public int timeThinking() {
        return 1000 * ((new Random().nextInt(5) + 1));
    }
}
