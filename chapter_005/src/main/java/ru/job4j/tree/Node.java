package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для описания узла дерева.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <T> тип хранимого в узле значения.
 */
public class Node<T> {

    /**
     * Список дочерних элементов.
     */
    private final List<Node<T>> children = new ArrayList<>();

    /**
     * Значение узла.
     */
    private T value;

    /**
     * Конструктор класса.
     * @param value значение узла.
     */
    public Node(final T value) {
        this.value = value;
    }

    /**
     * Метод для добавления дочернего элемента узлу.
     * @param child дочерний элемент.
     */
    public void addChild(T child) {
        this.children.add(new Node<>(child));
    }

    /**
     * Геттер для списка листьев узла (дочерних узлов).
     * @return список листьев.
     */
    public List<Node<T>> leaves() {
        return this.children;
    }

    /**
     * Метод для сравнения значения с ключевым значением узла.
     * @param that значение для сравнения.
     * @return идентичны ли значения.
     */
    public boolean eqValue(T that) {
        return this.value.equals(that);
    }

    /**
     * Геттер для значения узла.
     * @return значение узла.
     */
    public T getValue() {
        return value;
    }
}
