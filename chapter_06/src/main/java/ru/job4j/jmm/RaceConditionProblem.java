package ru.job4j.jmm;

/**
 * Класс для демонстрации проблемы условия гонок при записи общих данных.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class RaceConditionProblem {

    /**
     * Метод для демонстрации проблемы условия гонок.
     * Для двух потоков, работающих с общим объектом.
     */
    public void showRaceConditionProblem() {
        Thread firstThread = new Thread(Shared.SHARED_OBJECT_INSTANCE);
        Thread secondThread = new Thread(Shared.SHARED_OBJECT_INSTANCE);
        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

/**
 * Класс для описания общего для потоков объекта.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
class Shared implements Runnable {

    /**
     * Статический экземпляр класса, позволяет использовать один объект разным потокам.
     */
    public static final Shared SHARED_OBJECT_INSTANCE = new Shared();

    /**
     * Первое целочисленное поле.
     */
    private Integer object1 = new Integer(10);

    /**
     * Второе целочисленное поле.
     */
    private Integer object2 = new Integer(20);

    /**
     * Метод для запуска потока.
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "запущен.");
        methodOne();
        System.out.println(Thread.currentThread() + "закончен.");
    }

    /**
     * Метод для изменения целочисленных полей общего для потоков объекта.
     */
    private void methodOne() {
        object1 = 11;
        System.out.println("Первое поле изменено на " + object1);
        object2 = 21;
        System.out.println("Второе поле изменено на " + object2);
    }
}
