package ru.job4j.blocking;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Класс для пула потоков.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
@ThreadSafe
public class ThreadPool {

    /**
     * Поле для монитора.
     */
    private final Object lock = new Object();

    /**
     * Поле для блокирующей очереди экземпляров работы.
     */
    @GuardedBy("lock")
    private final FixedBlockingQueue<Runnable> workRunnersQueue = new FixedBlockingQueue<>(10);

    /**
     * Поле для флага (нужно ли работать пулу).
     */
    @GuardedBy("lock")
    private boolean isRunning = true;

    /**
     * Поле для хранилища потоков, выполняющих экземпляры работы.
     */
    @GuardedBy("lock")
    private final WorkThread[] workThreadArr;

    /**
     * Конструктор класса.
     * Количесвто потоков выполняющих экземпляры работы = количество ядер в системе.
     * @param coreNumber количество ядер в системе.
     */
    public ThreadPool(int coreNumber) {
        workThreadArr = new WorkThread[coreNumber];
        for (int i = 0; i < coreNumber; i++) {
            workThreadArr[i] = new WorkThread();
        }
    }

    /**
     * Метод для запуска потоков в пуле.
     */
    public void startThreadPool() {
        synchronized (lock) {
            for (WorkThread aWorkThread : workThreadArr) {
                aWorkThread.start();
            }
        }

    }

    /**
     * Метод для добавления экземпляра работы в очередь на выполнение.
     * @param command экземпляр работы.
     */
    public void add(Runnable command) {
        synchronized (lock) {
            if (isRunning) {
                try {
                    workRunnersQueue.push(command);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Метод для выставления флага на прекращение работы пула.
     */
    public void shutdown() {
        synchronized (lock) {
            isRunning = false;
            for (WorkThread aWorkThread : workThreadArr) {
                aWorkThread.interrupt();
            }
        }
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
            while (!this.isInterrupted()) {
                try {
                    workRunnersQueue.poll().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
