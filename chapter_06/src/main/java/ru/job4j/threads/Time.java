package ru.job4j.threads;

/**
 * Класс для проверки времени выполнения программы.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Time implements Runnable {

    /**
     * Поле для времени, отведенного на выполнение программы.
     */
    private long timeToWork;

    /**
     * Поток счетчика символов.
     */
    private Thread countCharThread;

    /**
     * Конструктор класса.
     * @param timeToWork время, отведенное на работу счетчика.
     * @param countCharThread поток счетчика символов.
     */
    public Time(long timeToWork, Thread countCharThread) {
        this.timeToWork = timeToWork;
        this.countCharThread = countCharThread;
    }

    /**
     * Метод для засекания времени выполнения программы.
     */
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (countCharThread.isAlive()) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - startTime >= timeToWork) {
                countCharThread.interrupt();
                System.out.println("Прерывание потока");
                try {
                    countCharThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
