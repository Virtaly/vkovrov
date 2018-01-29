package ru.job4j.blocking;

import org.junit.Test;
import org.junit.Before;

/**
 * Тест для класса SimpleLock.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */

public class SimpleLockTest {

    /**
     * Поле для замка.
     */
    private SimpleLock lock;

    /**
     * Метод для создания объекта замка перед запуском тестов.
     */
    @Before
    public void setUp() {
        lock = new SimpleLock();
    }

    /**
     * Тест для методов lock и unlock.
     */
    @Test
    public void lockCanHasOnlyOneOwner() {
        Thread firstThread = new Thread(() -> {
            lock.lock();
            System.out.println("Lock is acquiring by first thread");
            lock.unlock();
        });
        Thread secondThread = new Thread(() -> {
            lock.lock();
            System.out.println("Lock is acquiring by second thread");
            lock.unlock();
        });
        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}