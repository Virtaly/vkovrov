package ru.job4j.iteration;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс для описания итератора простых чисел.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class PrimeIterator implements Iterator {

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
    public PrimeIterator(int[] array) {
        this.array = array;
    }

    /**
     * Метод для определения наличия следующего элемента простого числа в массиве.
     * @return есть ли следующий элемент простого числа в массиве.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        while (fakeIndex < array.length) {
            if (this.isSimple(array[fakeIndex++])) {
                result = true;
                break;
            }
        }
        fakeIndex = index;
        return result;
    }

    /**
     * Метод для возвращения следующего элемента простого числа массива.
     * @return следующий элемент простого числа массива.
     */
    @Override
    public Object next() {
        fakeIndex = index;
        int item = 0;
        while (hasNext()) {
            item = array[index++];
            fakeIndex = index;
            if (isSimple(item)) {
                break;
            }
        }
        if (item == 0) {
            throw new NoSuchElementException();
        }
        return item;
    }

    /**
     * Метод для определения является ли число простым.
     * @param number число.
     * @return является ли число простым.
     */
    public boolean isSimple(int number) {
        boolean isSimple = true;
        if (number == 1) {
            isSimple = false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isSimple = false;
            }
        }
        return isSimple;
    }
}
