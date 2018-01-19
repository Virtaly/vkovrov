package ru.job4j.blocking;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Random;

/**
 * Класс для шаблона Producer Consumer.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
@ThreadSafe
public class ProducerConsumer {

    /**
     * Поле для монитора.
     */
    @GuardedBy("this.lock")
    private final Object lock = new Object();

    /**
     * Поле для флага блокировки потока.
     */
    @GuardedBy("this.lock")
    private boolean block = true;

    /**
     * Поле для массива хранящего очередь ограниченного размера.
     */
    @GuardedBy("this.lock")
    private FixedQueue<Integer> queue = new FixedQueue<>();

    /**
     * Метод для заполнения очереди.
     * @param enable значение флага.
     * @throws InterruptedException исключение прерывания потока.
     */
    public void fillQueue(boolean enable) throws InterruptedException {
        synchronized (this.lock) {
            while (!this.block) {
                lock.wait();
            }
            try {
                queue.push(new Random().nextInt(10));
                System.out.println(queue.toString());
            } catch (ArrayIndexOutOfBoundsException e) {
                this.block = enable;
                this.lock.notify();
            }
        }
    }

    /**
     * Метод для чтения очереди.
     * @param enable значение флага.
     * @throws InterruptedException исключение прерывания потока.
     */
    public void extractQueue(boolean enable) throws InterruptedException {
        synchronized (this.lock) {
            while (this.block) {
                lock.wait();
            }
            try {
                queue.poll();
                System.out.println(queue.toString());
            } catch (ArrayIndexOutOfBoundsException e) {

                this.block = enable;
                this.lock.notify();
            }
        }

    }
}

