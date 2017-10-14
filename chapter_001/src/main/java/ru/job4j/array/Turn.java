package ru.job4j.array;

/**
 * Класс Turn для переворачивания массива.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Turn {

    /**
     * Метод back для переворачивания массива.
     * Для перестановки местами чисел используется последовательность арифметических действий над ними,
     * что позволяет ибежать введения дополнительной переменной, работает для любых чисел.
     * @param array массив целочисленных элементов.
     * @return массив, элементы которого расположены в обратном порядке.
     */
    public int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            array[i] += array[array.length - i - 1];
            array[array.length - i - 1] = array[i] - array[array.length - i - 1];
            array[i] -= array[array.length - i - 1];
        }
        return array;
    }
}
