package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Класс для описания связного массива.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <E> тип хранимых в контейнере объектов.
 */
public class LinkedArray<E> implements Iterable<E> {

    /**
     * Поле для первого узла.
     */
    private Node<E> first;

    /**
     * Поле для последнего узла.
     */
    private Node<E> last;

    /**
     * Конструктор класса.
     */
    public LinkedArray() {
    }

    /**
     * Метод для добавления элемента в контейнер.
     * @param value элемент.
     */
    public void add(E value) {
        Node<E> newNode = new Node<>(last, value, null);
        if (last == null) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
    }

    /**
     * Метод для получения узла элемента из контейнера.
     * @param item элемент.
     * @return узел элемента контейнера.
     */
    public Node<E> getNode(E item) {
        Node<E> node = first;
        Node<E> result = null;
        while (node != null) {
            if (node.getData().equals(item)) {
                result = node;
                break;
            }
            node = node.getNext();
        }
        return result;
    }

    /**
     * Метод для получения элемента из контейнера.
     * @param item элемент.
     * @return элемент контейнера.
     */
    public E get(E item) {
        Node<E> node = first;
        E result = null;
        while (node != null) {
            if (node.getData().equals(item)) {
                result = node.getData();
                break;
            }
            node = node.getNext();
        }
        return result;
    }

    /**
     * Метод для получения первого элемента из контейнера.
     * @return первый элемент контейнера.
     */
    public E getFirst() {
        return this.first.getData();
    }

    /**
     * Метод для получения последнего элемента из контейнера.
     * @return последний элемент контейнера.
     */
    public E getLast() {
        return this.last.getData();
    }

    /**
     * Метод для удаления элемента из контейнера.
     * @param item значение элемента.
     * @return значение элемента.
     */
    public E remove(E item) {
        Node<E> node = this.getNode(item);
        if (node == first) {
            removeFirst(item);
        } else if (node == last) {
            removeLast(item);
        } else {
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
        }
        return node.getData();
    }

    /**
     * Метод для удаления первого элемента из контейнера.
     * @param item значение первого элемента.
     * @return значение первого элемента.
     */
    private E removeFirst(E item) {
        Node<E> node = this.getNode(item);
        node.getNext().setPrevious(null);
        first = node.getNext();
        return node.getData();
    }

    /**
     * Метод для удаления последнего элемента из контейнера.
     * @param item значение последнего элемента.
     * @return значение последнего элемента.
     */
    private E removeLast(E item) {
        Node<E> node = this.getNode(item);
        node.getPrevious().setNext(null);
        last = node.getPrevious();
        return node.getData();
    }

    /**
     * Метод для получения итератора для связного массива.
     * @return итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            /**
             * Текущий узел.
             */
            private Node<E> current = first;

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
                    throw new NoSuchElementException();
                }
                Node<E> node = current;
                current = current.getNext();
                return node.getData();
            }
        };
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
