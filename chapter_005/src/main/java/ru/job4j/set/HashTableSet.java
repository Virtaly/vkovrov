package ru.job4j.set;

import java.util.Arrays;

/**
 * Класс для описания множества на основе хэш-таблицы.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <E> тип хранимых в контейнере объектов.
 */
public class HashTableSet<E> {

    /**
     * Поле для структуры данных.
     */
    private Couple<E, Object>[] container;

    /**
     * Указатель на следующую свободную ячейку.
     */
    private int pointer = 0;

    /**
     * Конструктор класса.
     */
    public HashTableSet() {
        this.container = new Couple[10];
    }

    /**
     * Конструктор класса.
     * @param size размер контейнера.
     */
    public HashTableSet(int size) {
        this.container = new Couple[size];
    }

    /**
     * Метод для добавления элемента.
     * @param e значение элемента.
     * @return добавился ли элемент.
     */
    public boolean add(E e) {
        boolean arrayContainsE = this.contains(e);
        if (!arrayContainsE) {
            if (pointer >= container.length) {
                container = Arrays.copyOf(container, container.length * 2);
            }
            container[pointer++] = new Couple(e, new Object());
        }
        return !arrayContainsE;
    }

    /**
     * Метод для проверки наличия элемента в контейнере.
     * @param e значение элемента.
     * @return существует ли элемент с таким значением в контейнере.
     */
    public boolean contains(E e) {
        boolean arrayContainsE = false;
        for (int i = 0; i < pointer; i++) {
            if (e.equals(container[i].getKey())) {
                arrayContainsE = true;
                break;
            }
        }
        return arrayContainsE;
    }

    /**
     * Метод для удаления элемента.
     * @param e значение элемента.
     * @return удалился ли элемент.
     */
    public boolean remove(E e) {
        boolean arrayContainsE = false;
        for (int i = 0; i < pointer; i++) {
            if (e.equals(container[i].getKey())) {
                arrayContainsE = true;
                for (int j = i; j < pointer; j++) {
                    container[j] = container[j + 1];
                }
                pointer--;
                break;
            }
        }
        return arrayContainsE;
    }

    /**
     * Класс для описания пары ключ/значение.
     * @author vkovrov
     * @version 0.1
     * @since 0.1
     * @param <E> тип ключа.
     * @param <T> тип значения.
     */
    private class Couple<E, T> {

        /**
         * Поле для ключа.
         */
        private E key;

        /**
         * Поле для значения.
         */
        private T value;

        /**
         * Конструктор класса.
         * @param key ключ.
         * @param value значение.
         */
        Couple(E key, T value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Геттер для ключа.
         * @return ключ.
         */
        public E getKey() {
            return key;
        }
    }
}
