package ru.job4j.blocking;

import org.junit.Test;
import org.junit.Before;

/**
 * Тест для класса ProducerConsumer.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class ProducerConsumerTest {

    /**
     * Поле для шаблона Producer - Consumer.
     */
    private ProducerConsumer pc;

    /**
     * Метод для создания объекта шаблона перед запуском тестов.
     */
    @Before
    public void setUp() {
        this.pc = new ProducerConsumer();
    }

    /**
     * Тест для методов добавления и извлечения данных из очереди двумя потоками.
     * По шаблону Producer-Consumer.
     */
    @Test
    public void test() {
        Thread producerThread = new Thread(() -> {
            try {
                while (true) {
                    this.pc.fillQueue(false);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumerThread = new Thread(() -> {
            try {
                while (true) {
                    pc.extractQueue(true);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        consumerThread.start();
        producerThread.start();
        try {
            consumerThread.join();
            producerThread.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}