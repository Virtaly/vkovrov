package ru.job4j.tree;

import java.util.Optional;

/**
 * Интерфейс для описания простого дерева.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <T> тип хранимых в дереве объектов.
 */
public interface SimpleTree<T extends Comparable<T>> extends Iterable<T> {

    /**
     * Метод для добавления узла в дерево.
     * @param parent ключевое значение узла родителя.
     * @param child ключевое значение дочернего узла.
     * @return добавился ли узел.
     */
    boolean add(T parent, T child);

    /**
     * Поиск узла по значению.
     * @param value значение.
     * @return узел дерева с таким значением.
     */
    Optional<Node<T>> find(T value);
}
