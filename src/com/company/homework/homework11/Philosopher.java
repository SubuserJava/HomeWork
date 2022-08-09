package com.company.homework.homework11;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable {

    String name;
    ReentrantLock leftFork;
    ReentrantLock rightFork;

    public Philosopher(String name, ReentrantLock rightFork, ReentrantLock leftFork) {
        this.name = name;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
    }

    @Override
    public void run() {
        int timeThinking;
        int timeEating;
        do {
            try {
                if (!rightFork.isHeldByCurrentThread()) {
                    rightFork.tryLock();
                    timeThinking = timeThinking();
                    System.out.printf("Philosopher '%s' take right fork. Fork is one. Thinking %s sec...\n", name, timeThinking / 1000);
                    Thread.sleep(timeThinking);
                    if (!leftFork.isHeldByCurrentThread()) {
                        leftFork.tryLock();
                        timeEating = timeEating();
                        System.out.printf("Philosopher '%s' took two forks. Eating %s sec...\n", name, (timeEating() / 1000));
                        Thread.sleep(timeEating);

                        if (leftFork.isHeldByCurrentThread()) {
                            leftFork.unlock();
                        }
                        if (rightFork.isHeldByCurrentThread()) {
                            rightFork.unlock();
                        }

                        timeThinking = timeThinking();
                        System.out.printf("The philosopher '%s' ate and put the forks. Thinking %s sec...\n", name, (timeThinking / 1000));
                        Thread.sleep(timeThinking);
                    }
                }
            } catch (IllegalMonitorStateException | InterruptedException exception) {
                exception.printStackTrace();
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
