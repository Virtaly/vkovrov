package ru.job4j.blocking;

import java.util.Random;

/**
 * Класс для потока Producer.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Producer implements Runnable {

    /**
     * Поле для блокирующей ограниченной очереди.
     */
    private FixedBlockingQueue queue;

    /**
     * Конструктор класса.
     * @param q блокирующая ограниченная очередь.
     */
    public Producer(FixedBlockingQueue q) {
        this.queue = q;
    }

    /**
     * Метод для заполнения потоком очереди после его старта.
     */
    @Override
    public void run() {
        try {
            while (true) {
                this.queue.push(new Random().nextInt(100));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
