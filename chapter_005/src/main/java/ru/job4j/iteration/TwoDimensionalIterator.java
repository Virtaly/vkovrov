package ru.job4j.iteration;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс для описания итератора двумерного массива.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <E> тип элементов, хранимых в двумерном массиве.
 */
public class TwoDimensionalIterator<E> implements Iterator<E> {


    /**
     * Поле для массива.
     */
    private final E[][] array;

    /**
     * Поле для индекса по горизонтали.
     */
    private int xIndex = 0;

    /**
     * Поле для индекса по вертикали.
     */
    private int yIndex = 0;

    /**
     * Конструктор класса.
     * @param array массив.
     */
    public TwoDimensionalIterator(final E[][] array) {
        this.array = array;
    }

    /**
     * Метод для определения наличия следующего элемента двумерного массива.
     * @return есть ли следующий элемент в двумерном массиве.
     */
    @Override
    public boolean hasNext() {
        return (yIndex < array.length) && (xIndex < array[yIndex].length);
    }

    /**
     * Метод для возвращения следующего элемента двумерного массива.
     * @return следующий элемент двумерного массива.
     */
    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int x = xIndex;
        int y = yIndex;
        xIndex = xIndex < array[yIndex].length - 1 ? ++xIndex : 0;
        yIndex = xIndex == 0 ? ++yIndex : yIndex;
        return array[y][x];

    }
}
