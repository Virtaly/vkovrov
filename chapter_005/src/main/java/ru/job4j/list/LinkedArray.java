package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Класс для описания связного массива.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <E> тип хранимых в контейнере объектов.
 */
@ThreadSafe
public class LinkedArray<E> implements Iterable<E> {

    /**
     * Поле для первого узла.
     */
    @GuardedBy("this")
    private Node<E> first;

    /**
     * Поле для последнего узла.
     */
    @GuardedBy("this")
    private Node<E> last;

    /**
     * Поле для размера списка.
     */
    @GuardedBy("this")
    private int size = 0;

    /**
     * Метод для добавления элемента в контейнер.
     * @param value элемент.
     */
    public synchronized void add(E value) {
        Node<E> newNode = new Node<>(last, value, null);
        if (last == null) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    /**
     * Метод для определения есть ли элемент в контейнере.
     * @param e значение элемента.
     * @return есть ли элемент в контейнере.
     */
    public synchronized boolean contains(E e) {
        boolean arrayContainsE = false;
        Node<E> newNode = first;
        while (newNode != null) {
            if (e.equals(newNode.getData())) {
                arrayContainsE = true;
                break;
            }
            newNode = newNode.getNext();
        }
        return arrayContainsE;
    }

    /**
     * Метод для получения узла элемента из контейнера.
     * @param item элемент.
     * @return узел элемента контейнера.
     */
    public synchronized Node<E> getNode(E item) {
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
     * @param index индекс элемента.
     * @return элемент контейнера.
     */
    public synchronized E get(int index) {
        if (index >= size) {
            throw new IllegalArgumentException();
        }
        Node<E> node = first;
        for (int i = 1; i <= index; i++) {
            node = node.getNext();
        }
        return node.getData();
    }

    /**
     * Метод для получения первого элемента из контейнера.
     * @return первый элемент контейнера.
     */
    public synchronized Node<E> getFirst() {
        return this.first;
    }

    /**
     * Метод для получения последнего элемента из контейнера.
     * @return последний элемент контейнера.
     */
    public synchronized Node<E> getLast() {
        return this.last;
    }

    /**
     * Метод для удаления элемента из контейнера.
     * @param item значение элемента.
     * @return значение элемента.
     */
    public synchronized E remove(E item) {
        Node<E> node = this.getNode(item);
        if (node == first) {
            removeFirst(item);
        } else if (node == last) {
            removeLast(item);
        } else {
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
        }
        size--;
        return node.getData();
    }

    /**
     * Метод для удаления первого элемента из контейнера.
     * @param item значение первого элемента.
     * @return значение первого элемента.
     */
    private synchronized E removeFirst(E item) {
        Node<E> node = this.getNode(item);
        if (node.getNext() != null) {
            node.getNext().setPrevious(null);
        }
        first = node.getNext();
        return node.getData();
    }

    /**
     * Метод для удаления последнего элемента из контейнера.
     * @param item значение последнего элемента.
     * @return значение последнего элемента.
     */
    private synchronized E removeLast(E item) {
        Node<E> node = this.getNode(item);
        if (node.getPrevious() != null) {
            node.getPrevious().setNext(null);
        }
        last = node.getPrevious();
        return node.getData();
    }

    /**
     * Метод для получения итератора для связного массива.
     * @return итератор.
     */
    @Override
    public synchronized Iterator<E> iterator() {
        return new Iterator<E>() {

            /**
             * Текущий узел.
             */
            @GuardedBy("this")
            private Node<E> current = first;

            /**
             * Метод для определения наличия следующего элемента в массиве.
             * @return есть ли следующий элемент в массиве.
             */
            @Override
            public synchronized boolean hasNext() {
                return current != null;
            }

            /**
             * Метод для возвращения следующего элемента массива.
             * @return следующий элемент массива.
             */
            @Override
            public synchronized E next() {
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
    @ThreadSafe
    public class Node<T> {

        /**
         * Поле для предыдущего узла.
         */
        @GuardedBy("this")
        private Node<T> previous;

        /**
         * Поле для данных, хранимых в узле.
         */
        @GuardedBy("this")
        private T data;

        /**
         * Поле для следующего узла.
         */
        @GuardedBy("this")
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
        public synchronized Node<T> getPrevious() {
            return previous;
        }

        /**
         * Cеттер для предыдущего узла.
         * @param previous предыдущий узел.
         */
        public synchronized void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        /**
         * Геттер для данных, хранимых в узле.
         * @return данные, хранимые в узле.
         */
        public synchronized T getData() {
            return data;
        }

        /**
         * Cеттер для данных, хранимых в узле.
         * @param data данные, хранимые в узле.
         */
        public synchronized void setData(T data) {
            this.data = data;
        }

        /**
         * Геттер для следующего узла.
         * @return следующий узел.
         */
        public synchronized Node<T> getNext() {
            return next;
        }

        /**
         * Cеттер для следующего узла.
         * @param next следующий узел.
         */
        public synchronized void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
