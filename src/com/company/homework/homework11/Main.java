package com.company.homework.homework11;

/**
 *  У меня так и не получилось добиться управления потоками массива forks.
 *  Я просто не понимаю, что делать дальше в этой задаче.
 *  Бился неделю, не даётся...
 *
 *  Если запускать правую и левую "вилки" без операций "размышлений", то всё нормально.
 *  Как только добавляются попытки заморозить поток, при запуске программы, происходит deadlock всех 5-ти вилок.
 *  Дальше программа не работает.
 *  При попытке проверить потоки isLocked, вываливаетсяч ошибки IllegalMonitorException.
 *  Так и не понял, как доделать... В прктическом плане, к сожалению, тему потоков так не освоил в должной мере.
 *  По отдельности, вроде, всё понятно. Как это соединять на практике, не понимаю...
 *  В конечном итоге, переключился на экзаменационную работу.
 */

public class Main {

    public static void main(String[] args) {

        new Thread(new Philosopher(0)).start();
        new Thread(new Philosopher(1)).start();
        new Thread(new Philosopher(2)).start();
        new Thread(new Philosopher(3)).start();
        new Thread(new Philosopher(4)).start();
    }
}
