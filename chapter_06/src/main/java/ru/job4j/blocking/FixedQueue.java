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
public class FixedQueue<T> {

    /**
     * Поле для структуры данных, используемой для хранения данных очереди.
     */
    private List<T> list = new LinkedList<>();

    /**
     * Количество элементов в структуре данных.
     */
    private int size = 0;

    /**
     * Метод для добавления данных в конец очереди.
     * @throws ArrayIndexOutOfBoundsException исключение переполнения очереди.
     * @param value значение данных.
     */
    public void push(T value) {
        if (size < 10) {
            list.add(value);
            size++;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Метод для извлечения данных из начала очереди.
     * @throws ArrayIndexOutOfBoundsException исключение пустой очереди.
     * @return извлекаемое значение.
     */
    public T poll() {
        T value;
        if (size > 0) {
            value = list.remove(0);
            size--;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return value;
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
