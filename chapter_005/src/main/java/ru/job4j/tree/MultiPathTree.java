package ru.job4j.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

/**
 * Класс для описания дерева.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <T> тип хранимых в дереве значений.
 */
public class MultiPathTree<T extends Comparable<T>> implements SimpleTree<T> {

    /**
     * Поле для корневого узла дерева.
     */
    private Node<T> root;

    /**
     * Конструктор класса.
     * @param rootValue ключевое значение узла.
     */
    public MultiPathTree(T rootValue) {
        this.root = new Node<>(rootValue);
    }

    /**
     * Метод для добавления узла в дерево.
     * @param parent ключевое значение узла родителя.
     * @param child ключевое значение дочернего узла.
     * @return добавился ли узел.
     */
    @Override
    public boolean add(T parent, T child) {
        boolean isAdded = false;
        if (!this.find(child).isPresent()) {
            this.find(parent).get().addChild(child);
            isAdded = true;
        }
        return isAdded;
    }

    /**
     * Поиск узла по значению.
     * @param value значение.
     * @return найденный узел.
     */
    @Override
    public Optional<Node<T>> find(T value) {
        Optional<Node<T>> result = Optional.empty();
        Queue<Node<T>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<T> el = data.poll();
            if (el.eqValue(value)) {
                result = Optional.of(el);
                break;
            }
            for (Node<T> child : el.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }

    /**
     * Метод для определения бинарности дерева.
     * @return бинарно ли дерево.
     */
    public boolean isBinary() {
        boolean isBinary = true;
        Queue<Node<T>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<T> el = data.poll();
            if (el.leaves().size() > 2) {
                isBinary = false;
                break;
            }
            for (Node<T> child : el.leaves()) {
                data.offer(child);
            }
        }
        return isBinary;
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
            private List<Node<T>> nodes = fillNodesList(root);

            /**
             * Указатель на текущий узел.
             */
            private int current = 0;

            /**
             * Метод для заполнения списка узлами.
             * @param node корневой узел, с которого начинается заполнение списка узлами.
             * @return список с узлами.
             */
            private List<Node<T>> fillNodesList(Node<T> node) {
                List<Node<T>> list = new LinkedList<>();
                Queue<Node<T>> data = new LinkedList<>();
                data.offer(node);
                while (!data.isEmpty()) {
                    Node<T> el = data.poll();
                    list.add(el);
                    for (Node<T> child : el.leaves()) {
                        data.offer(child);
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
}
