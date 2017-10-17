package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс ArrayDuplicate для удаления дубликатов в массиве.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class ArrayDuplicate {
    /**
     * Метод удаляет дубликаты строк из массива.
     * Все дубликаты переставляются в конец массива,
     * при возвращении из метода часть массива с дубликатами отбрасывается.
     * @param array массив строк.
     * @return массив строк без дубликатов.
     */
    public String[] remove(String[] array) {
        int startIndexOfDuplicates = array.length;
        for (int i = 0; i < startIndexOfDuplicates; i++) {
            for (int j = i + 1; j < startIndexOfDuplicates; j++) {
                if (array[i].equals(array[j])) {
                    String temp = array[j];
                    array[j] = array[startIndexOfDuplicates - 1];
                    array[startIndexOfDuplicates - 1] = temp;
                    startIndexOfDuplicates--;
                }
            }
        }
        return Arrays.copyOf(array, startIndexOfDuplicates);
    }
}
