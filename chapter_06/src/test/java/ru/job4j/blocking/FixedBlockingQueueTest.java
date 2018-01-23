package ru.job4j.blocking;

import org.junit.Test;
import org.junit.Before;

/**
 * Тест для класса FixedBlockingQueue.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class FixedBlockingQueueTest {

    /**
     * Поле для ограниченной блокирующей очереди.
     */
    private FixedBlockingQueue fbq;

    /**
     * Метод для создания объекта очереди перед запуском тестов.
     */
    @Before
    public void setUp() {
        this.fbq = new FixedBlockingQueue();
    }

    /**
     * Тест для методов добавления и извлечения данных из очереди двумя потоками.
     * По шаблону Producer-Consumer.
     */
    @Test
    public void test() {
        Thread producer = new Thread(new Producer(fbq));
        Thread consumer = new Thread(new Consumer(fbq));
        producer.start();
        consumer.start();
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}