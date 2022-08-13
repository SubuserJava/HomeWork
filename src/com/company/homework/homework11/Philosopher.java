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
        try {
            while (true) {
                if (!getStateCurrentThread(rightFork)) {
                    rightFork.tryLock();
                    timeThinking = getTimeThinking();
                    System.out.printf("Philosopher '%s' take right fork. Fork is one. Thinking %s sec...\n", name, timeThinking / 1000);
                    Thread.sleep(timeThinking);
                    if (!getStateCurrentThread(leftFork)) {
                        leftFork.tryLock();
                        timeEating = getTimeEating();
                        System.out.printf("Philosopher '%s' took two forks. Eating %s sec...\n", name, (getTimeEating() / 1000));
                        Thread.sleep(timeEating);

                        if (getStateCurrentThread(leftFork)) {
                            leftFork.unlock();
                        }
                        if (getStateCurrentThread(rightFork)) {
                            rightFork.unlock();
                        }

                        timeThinking = getTimeThinking();
                        System.out.printf("The philosopher '%s' ate and put the forks. Thinking %s sec...\n", name, (timeThinking / 1000));
                        Thread.sleep(timeThinking);
                    }
                }
            }
        } catch (IllegalMonitorStateException | InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    private boolean getStateCurrentThread(ReentrantLock reentrantLock) { return reentrantLock.isHeldByCurrentThread(); }

    public int getTimeEating() {
        return 1000 * ((new Random().nextInt(10) + 1));
    }

    public int getTimeThinking() {
        return 1000 * ((new Random().nextInt(5) + 1));
    }
}
