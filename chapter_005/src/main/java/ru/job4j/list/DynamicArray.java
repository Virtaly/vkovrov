package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Класс для описания динамического массива.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <E> тип хранимых в контейнере объектов.
 */
public class DynamicArray<E> implements Iterable<E> {

    /**
     * Поле для массива.
     */
    private Object[] container;

    /**
     * Указатель на следующую свободную ячейку.
     */
    private int pointer = 0;

    /**
     * Конструктор класса.
     */
    public DynamicArray() {
        this.container = new Object[10];
    }

    /**
     * Конструктор класса.
     * @param size размер контейнера.
     */
    public DynamicArray(int size) {
        this.container = new Object[size];
    }

    /**
     * Метод для добавления элемента в контейнер.
     * @param value элемент.
     */
    public void add(E value) {
        if (pointer >= container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[pointer++] = value;
    }

    /**
     * Метод для получения элемента из контейнера.
     * @param index индекс элемента.
     * @return элемент контейнера.
     */
    public E get(int index) {
        if (index >= pointer) {
            throw new NoSuchElementException();
        }
        return (E) container[index];
    }

    /**
     * Метод для получения итератора для динамического массива.
     * @return итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            /**
             * Поле для индекса.
             */
            private int index = 0;

            /**
             * Метод для определения наличия следующего элемента в массиве.
             * @return есть ли следующий элемент в массиве.
             */
            @Override
            public boolean hasNext() {
                return index < pointer;
            }

            /**
             * Метод для возвращения следующего элемента массива.
             * @return следующий элемент массива.
             */
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[index++];
            }
        };
    }
}
