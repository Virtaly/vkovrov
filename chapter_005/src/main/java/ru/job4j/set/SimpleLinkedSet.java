package ru.job4j.set;

import ru.job4j.list.LinkedArray;

import java.util.Iterator;

/**
 * Класс для описания связного множества.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <E> тип хранимых в контейнере объектов.
 */
public class SimpleLinkedSet<E> implements Iterator<E> {

    /**
     * Поле для связного списка.
     */
    private LinkedArray<E> linked;

    /**
     * Поле для итератора связного списка.
     */
    private Iterator<E> iterator;

    /**
     * Поле для флага итератора.
     */
    private boolean iteratorFlag;

    /**
     * Конструктор класса.
     */
    public SimpleLinkedSet() {
        this.linked = new LinkedArray<>();
    }

    /**
     * Метод для добавления элемента в контейнер.
     * @param e элемент.
     */
    public void add(E e) {
        if (!linked.contains(e)) {
            linked.add(e);
            iteratorFlag = false;
        }
    }

    /**
     * Метод для удаления элемента из контейнера.
     * @param e элемент.
     */
    public void remove(E e) {
        linked.remove(e);
    }

    /**
     * Метод для определения наличия следующего элемента в массиве.
     * @return есть ли следующий элемент в массиве.
     */
    @Override
    public boolean hasNext() {
        createIterator();
        return iterator.hasNext();
    }

    /**
     * Метод для возвращения следующего элемента массива.
     * @return следующий элемент массива.
     */
    @Override
    public E next() {
        createIterator();
        return iterator.next();
    }

    /**
     * Метод для создания итератора.
     */
    private void createIterator() {
        if (!iteratorFlag) {
            iterator = linked.iterator();
            iteratorFlag = true;
        }
    }

    /**
     * Геттер для первого узла множества.
     * @return первого значения множества.
     */
    public LinkedArray.Node getFirst() {
        return linked.getFirst();
    }
}
