package ru.job4j.iteration;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс для описания итератора чисел.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class EvenIterator implements Iterator {

    /**
     * Поле для массива.
     */
    private final int[] array;

    /**
     * Поле для индекса.
     */
    private int index = 0;

    /**
     * Поле для индекса поиска элементов в методе hasNext.
     */
    private int fakeIndex = 0;

    /**
     * Конструктор класса.
     * @param array массив.
     */
    public EvenIterator(int[] array) {
        this.array = array;
    }

    /**
     * Метод для определения наличия следующего четного элемента в массиве.
     * @return есть ли следующий четный элемент в массиве.
     */
    @Override
    public boolean hasNext() {
        boolean result;
        if (fakeIndex < array.length) {
            result = array[fakeIndex++] % 2 == 0 || hasNext();
        } else {
            result = false;
        }
        fakeIndex = index;
        return result;
    }

    /**
     * Метод для возвращения следующего четного элемента массива.
     * @return следующий четный элемент массива.
     */
    @Override
    public Object next() {
        fakeIndex = index;
        if (!hasNext()) {
           throw new NoSuchElementException();
        } else {
            int item = array[index++];
            fakeIndex = index;
            return item % 2 == 0 ? item : next();
        }

    }
}
