package ru.job4j.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс для описания множества.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <E> тип хранимых в контейнере объектов.
 */
public class SimpleSet<E> implements Iterator<E> {

    /**
     * Поле для массива.
     */
    private Object[] container;

    /**
     * Указатель на следующую свободную ячейку.
     */
    private int pointer = 0;

    /**
     * Поле для индекса итератора.
     */
    private int index = 0;

    /**
     * Конструктор класса.
     */
    public SimpleSet() {
        this.container = new Object[10];
    }

    /**
     * Конструктор класса.
     * @param size размер контейнера.
     */
    public SimpleSet(int size) {
        this.container = new Object[size];
    }

    /**
     * Метод для добавления элемента в контейнер.
     * @param e элемент.
     */
    public void add(E e) {
        boolean arrayContainsE = false;
        for (int i = 0; i < pointer; i++) {
            if (e.equals((E) container[i])) {
                arrayContainsE = true;
                break;
            }
        }
        if (!arrayContainsE) {
            if (pointer >= container.length) {
                container = Arrays.copyOf(container, container.length * 2);
            }
            container[pointer++] = e;
        }
    }

    /**
     * Метод для определения наличия следующего элемента в множестве.
     * @return есть ли следующий элемент в множестве.
     */
    @Override
    public boolean hasNext() {
        return index < pointer;
    }

    /**
     * Метод для возвращения следующего элемента множества.
     * @return следующий элемент множества.
     */
    @Override
    public E next() {
        if (!hasNext()) {
            index = 0;
            throw new NoSuchElementException();
        }
        return (E) container[index++];
    }
}
