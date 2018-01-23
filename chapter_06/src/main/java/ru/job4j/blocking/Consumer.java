package ru.job4j.blocking;

/**
 * Класс для потока Consumer.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Consumer implements Runnable {

    /**
     * Поле для блокирующей ограниченной очереди.
     */
    private FixedBlockingQueue queue;

    /**
     * Конструктор класса.
     * @param q блокирующая ограниченная очередь.
     */
    public Consumer(FixedBlockingQueue q) {
        this.queue = q;
    }

    /**
     * Метод для извлечения потоком значений из очереди после его старта.
     */
    @Override
    public void run() {
        try {
            while (true) {
                queue.poll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
