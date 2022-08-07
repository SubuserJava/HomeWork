package com.company.homework.homework11;

import java.util.concurrent.locks.ReentrantLock;

public interface Forks {

    ReentrantLock[] forks = {new ReentrantLock(), new ReentrantLock(), new ReentrantLock(), new ReentrantLock(),
            new ReentrantLock()};
}
