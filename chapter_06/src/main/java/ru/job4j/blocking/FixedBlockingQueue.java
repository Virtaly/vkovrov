package ru.job4j.blocking;

import java.util.LinkedList;
import java.util.List;

/**
 * Класс для очереди фиксированного размера.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <T> тип хранимых данных.
 */
public class FixedBlockingQueue<T> {

    /**
     * Поле для структуры данных, используемой для хранения данных очереди.
     */
    private List<T> list = new LinkedList<>();

    /**
     * Метод для добавления данных в конец очереди.
     * @param value значение данных.
     * @throws InterruptedException исключение прерывания потока.
     */
    public synchronized void push(T value) throws InterruptedException {
        while (list.size() == 10) {
            wait();
        }
        if (list.size() < 10) {
            notify();
        }
        list.add(value);
        System.out.println(this.toString());
    }

    /**
     * Метод для извлечения данных из начала очереди.
     * @throws InterruptedException исключение прерывания потока.
     * @return извлекаемое значение.
     */
    public synchronized T poll() throws InterruptedException {
        while (list.size() == 0) {
            wait();
        }
        if (list.size() < 10) {
            notify();
        }
        T t = list.remove(0);
        System.out.println(this.toString());
        return t;
    }

    /**
     * Метод для строкового представления очереди.
     * @return строковое представление очереди.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T t : list) {
            builder.append(t);
        }
        return builder.toString();
    }
}
