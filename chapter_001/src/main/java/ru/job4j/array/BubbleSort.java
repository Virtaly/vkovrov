package ru.job4j.array;

/**
 * Класс BubbleSort для сортировки массива с помощью алгоритма пузырек.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class BubbleSort {

    /**
     * Метод sort для сортировки массива пузырьком.
     * Для перестановки местами чисел используется последовательность арифметических действий над ними,
     * что позволяет ибежать введения дополнительной переменной, работает для любых чисел.
     * @param array массив целочисленных элементов.
     * @return отсортированный по возрастанию массив.
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] += array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] -= array[j + 1];
                }
            }
        }
        return array;
    }
}
