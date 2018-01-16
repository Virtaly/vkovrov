package ru.job4j.synchronize;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Класс для параллельного увеличения счетчика.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
@ThreadSafe
public class Count {

    /**
     * Поле для счетчика.
     */
    @GuardedBy("this")
    private int value;

    /**
     * Метод для увеличения счетчика.
     */
    public synchronized void increment() {
        this.value++;
    }

    /**
     * Геттер для счетчика.
     * @return счетчик.
     */
    public synchronized int getValue() {
        return this.value;
    }
}
