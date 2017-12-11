package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс для описания связного множества.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <E> тип хранимых в контейнере объектов.
 */
public class SimpleLinkedSet<E> implements Iterator<E> {

    /**
     * Поле для первого узла.
     */
    private Node<E> first;

    /**
     * Поле для последнего узла.
     */
    private Node<E> last;

    /**
     * Текущий узел для итератора.
     */
    private Node<E> current;

    /**
     * Метод для добавления элемента в контейнер.
     * @param e элемент.
     */
    public void add(E e) {
        boolean arrayContainsE = false;
        Node<E> newNode = first;
        while (newNode != null) {
            if (e.equals(newNode.getData())) {
                arrayContainsE = true;
                break;
            }
            newNode = newNode.getNext();
        }
        if (!arrayContainsE) {
            newNode = new Node<>(last, e, null);
            if (last == null) {
                first = newNode;
                current = first;
            } else {
                last.setNext(newNode);
            }
            last = newNode;
        }
    }

    /**
     * Метод для определения наличия следующего элемента в массиве.
     * @return есть ли следующий элемент в массиве.
     */
    @Override
    public boolean hasNext() {
        return current != null;
    }

    /**
     * Метод для возвращения следующего элемента массива.
     * @return следующий элемент массива.
     */
    @Override
    public E next() {
        if (!hasNext()) {
            current = first;
            throw new NoSuchElementException();
        }
        Node<E> node = current;
        current = current.getNext();
        return node.getData();
    }

    /**
     * Класс для описания узла связного массива.
     * @author vkovrov
     * @version 0.1
     * @since 0.1
     * @param <T> тип хранимого в узле объекта.
     */
    private class Node<T> {

        /**
         * Поле для предыдущего узла.
         */
        private Node<T> previous;

        /**
         * Поле для данных, хранимых в узле.
         */
        private T data;

        /**
         * Поле для следующего узла.
         */
        private Node<T> next;

        /**
         * Конструктор класса.
         * @param previous предыдущий узел.
         * @param data данные, хранимые в узле.
         * @param next следующий узел.
         */
        Node(Node<T> previous, T data, Node<T> next) {
            this.previous = previous;
            this.data = data;
            this.next = next;
        }

        /**
         * Геттер для предыдущего узла.
         * @return предыдущий узел.
         */
        public Node<T> getPrevious() {
            return previous;
        }

        /**
         * Cеттер для предыдущего узла.
         * @param previous предыдущий узел.
         */
        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        /**
         * Геттер для данных, хранимых в узле.
         * @return данные, хранимые в узле.
         */
        public T getData() {
            return data;
        }

        /**
         * Cеттер для данных, хранимых в узле.
         * @param data данные, хранимые в узле.
         */
        public void setData(T data) {
            this.data = data;
        }

        /**
         * Геттер для следующего узла.
         * @return следующий узел.
         */
        public Node<T> getNext() {
            return next;
        }

        /**
         * Cеттер для следующего узла.
         * @param next следующий узел.
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
