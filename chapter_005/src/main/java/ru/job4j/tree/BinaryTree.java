package ru.job4j.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
             * Список для хранения всех узлов.
             */
            private List<BinaryNode<T>> nodes = fillNodesList(root);

            /**
             * Указатель на текущий узел.
             */
            private int current = 0;

            /**
             * Метод для заполнения списка узлами.
             * @param node корневой узел, с которого начинается заполнение списка узлами.
             * @return список с узлами.
             */
            private List<BinaryNode<T>> fillNodesList(BinaryNode<T> node) {
                List<BinaryNode<T>> list = new LinkedList<>();
                Queue<BinaryNode<T>> data = new LinkedList<>();
                data.offer(node);
                while (!data.isEmpty()) {
                    BinaryNode<T> el = data.poll();
                    list.add(el);
                    if (el.leftChild != null) {
                        data.offer(el.leftChild);
                    }
                    if (el.rightChild != null) {
                        data.offer(el.rightChild);
                    }
                }
                return list;
            }

            /**
             * Метод для определения наличия следующего элемента в списке.
             * @return есть ли следующий элемент в списке.
             */
            @Override
            public boolean hasNext() {
                return current < nodes.size();
            }

            /**
             * Метод для возвращения следующего элемента списка.
             * @return следующий элемент списка.
             */
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalArgumentException();
                }
                return nodes.get(current++).getValue();
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
