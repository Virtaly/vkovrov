package ru.job4j.blocking;

import org.junit.Test;
import org.junit.Before;

/**
 * Тест для класса ThreadPool.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class ThreadPoolTest {

    /**
     * Поле для пула потоков.
     */
    private ThreadPool threadPool;

    /**
     * Класс для описания экземпляров работы,
     * которые будут храниться в очереди на выполнение в пуле потоков.
     */
    private class WorkRunner implements Runnable {

        /**
         * Поле для номера экземпляра.
         */
        private int workNumber;

        /**
         * Конструктор класса.
         * @param workNumber номер экземпляра.
         */
        private WorkRunner(int workNumber) {
            this.workNumber = workNumber;
        }

        /**
         * Метод, выполняющийся при запуске на выполнение.
         */
        @Override
        public void run() {
            System.out.println("WorkRunner " + this.workNumber + " is started.");
            System.out.println("WorkRunner " + this.workNumber + " is finished.");
        }

        @Override
        public String toString() {
            return "WorkRunner{" + workNumber + "} ";
        }
    }

    /**
     * Метод для создания объекта пула перед запуском тестов.
     */
    @Before
    public void setUp() {
        threadPool = new ThreadPool(Runtime.getRuntime().availableProcessors());
    }


    /**
     * Тест для пула потоков, должен обработать все экземпляры работы в очереди.
     */
    @Test
    public void whenQueueHasWorkRunnersThenThreadPoolWillExecuteAllOfThem() {
        for (int i = 0; i < 100; i++) {
            threadPool.add(new WorkRunner(i));
        }
    }

}