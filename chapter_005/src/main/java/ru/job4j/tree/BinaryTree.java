package ru.job4j.tree;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс для описания бинарного дерева.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <T> тип хранимых в дереве значений.
 */
public class BinaryTree<T extends Comparable<T>> implements Iterable<T> {

    /**
     * Корень дерева.
     */
    private BinaryNode<T> root;

    /**
     * Метод для добавления узла в дерево.
     * @param value ключевое значение узла.
     * @return добавился ли узел.
     */
    public boolean add(T value) {
        BinaryNode<T> current = root;
        boolean isAdded = true;
        if (root == null) {
            root = new BinaryNode<>(value);
        } else {
            while (true) {
                if (current.getValue().compareTo(value) == 0) {
                    isAdded = false;
                    break;
                } else if (current.getValue().compareTo(value) > 0) {
                    if (current.leftChild == null) {
                        current.leftChild = new BinaryNode<>(value);
                        break;
                    }
                    current = current.leftChild;
                } else {
                    if (current.rightChild == null) {
                        current.rightChild = new BinaryNode<>(value);
                        break;
                    }
                    current = current.rightChild;
                }
            }
        }
        return isAdded;
    }

    /**
     * Поиск узла по значению.
     * @param value значение.
     * @return найденный узел.
     */
    public BinaryNode<T> find(T value) {
        BinaryNode<T> current = root;
        BinaryNode<T> result = null;
        while (current != null) {
            if (current.getValue().compareTo(value) == 0) {
                result = current;
                break;
            } else if (current.getValue().compareTo(value) > 0) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        return result;
    }

    /**
     * Метод для получения итератора дерева.
     * @return итератор.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            /**
             * Поле для текущего элемента.
             */
            private BinaryNode<T> current = root;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T result = current.getValue();
                current = current.leftChild != null ? current.leftChild : current.rightChild;
                return result;
            }
        };
    }

    /**
     * Класс для описания узла бинарного дерева.
     * @author vkovrov
     * @version 0.1
     * @since 0.1
     * @param <T> тип хранимого в узле значения.
     */
     class BinaryNode<T> {

        /**
         * Левый дочерний узел.
         */
        private BinaryNode<T> leftChild;

        /**
         * Правый дочерний узел.
         */
        private BinaryNode<T> rightChild;

        /**
         * Значение узла.
         */
        private T value;

        /**
         * Конструктор класса.
         * @param value значение узла.
         */
        BinaryNode(final T value) {
            this.value = value;
        }

        /**
         * Геттер для значения узла.
         * @return значение узла.
         */
        public T getValue() {
            return value;
        }
    }
}
