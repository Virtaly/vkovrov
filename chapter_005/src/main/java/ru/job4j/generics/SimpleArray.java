package ru.job4j.generics;

/**
 * Класс для описания простой коллекции.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <T> тип хранимых в массиве значений.
 */
public class SimpleArray<T> {

    /**
     * Поле для массива.
     */
    private Object[] array;

    /**
     * Поле для указателя на текущий элемент.
     */
    private int cursor = 0;

    /**
     * Констурктор класса.
     * @param size размер массива.
     */
    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Метод для добавления элемента в массив.
     * @param item элемент.
     */
    public void add(T item) {
        if (cursor < array.length) {
            this.array[cursor++] = item;
        }
    }

    /**
     * Метод для обновления элемента.
     * @param index индекс элемента.
     * @param item элемент для обновления.
     */
    public void update(int index, T item) {
        if (this.array[index] != null) {
            this.array[index] = item;
        }
    }

    /**
     * Метод для удаления элемента из массива.
     * @param index индекс удаляемого массива.
     */
    public void delete(int index) {
        if (index < cursor) {
            for (int i = index; i < cursor; i++) {
                this.array[i] = this.array[i + 1];
            }
            this.array[--cursor] = null;
        }
    }

    /**
     * Метод для получения элемента из массива.
     * @param index индекс массива.
     * @return элемент массива.
     */
    public T get(int index) {
        return (T) this.array[index];
    }

    /**
     * Метод для получения длины заполненного массива.
     * @return длина заполненного массива.
     */
    public int getLength() {
        return this.cursor;
    }
}
