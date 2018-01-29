package ru.job4j.blocking;

/**
 * Класс для пула потоков.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class ThreadPool {

    /**
     * Поле для блокирующей очереди экземпляров работы.
     */
    private final FixedBlockingQueue<Runnable> workRunnersQueue = new FixedBlockingQueue<>(10);

    /**
     * Поле для флага (нужно ли работать пулу).
     */
    private volatile boolean isRunning = true;

    /**
     * Конструктор класса.
     * Количесвто потоков выполняющих экземпляры работы = количество ядер в системе.
     * @param coreNumber количество ядер в системе.
     */
    public ThreadPool(int coreNumber) {
        for (int i = 0; i < coreNumber; i++) {
            new WorkThread().start();
        }
    }

    /**
     * Метод для добавления экземпляра работы в очередь на выполнение.
     * @param command экземпляр работы.
     */
    public void add(Runnable command) {
        if (isRunning) {
            try {
                workRunnersQueue.push(command);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод для выставления флага на прекращение работы пула.
     */
    public synchronized void shutdown() {
        isRunning = false;
    }

    /**
     * Класс для потоков пула, выполняющих экземпляры работы из очереди.
     * @author vkovrov
     * @version 0.1
     * @since 0.1
     */
    private class WorkThread extends Thread {

        /**
         * Метод для выполнения при запуске потока.
         */
        @Override
        public void run() {
            while (isRunning || workRunnersQueue.getSize() > 0) {
                try {
                    workRunnersQueue.poll().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                this.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
