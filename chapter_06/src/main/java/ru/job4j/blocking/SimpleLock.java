package ru.job4j.blocking;

/**
 * Класс для механизма блокировок SimpleLock.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class SimpleLock {

    /**
     * Поле для потока захватывающего замок.
     */
    private Thread isLockedBy;

    /**
     * Метод для захвата потоком замка.
     */
    public synchronized void lock() {
        while (isLockedBy != null && isLockedBy != Thread.currentThread()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLockedBy = Thread.currentThread();
    }

    /**
     * Метод для освобождения потоком замка.
     */
    public synchronized void unlock() {
        if (isLockedBy == Thread.currentThread()) {
            isLockedBy = null;
            notify();
        }
    }
}
