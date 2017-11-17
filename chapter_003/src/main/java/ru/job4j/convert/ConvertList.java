package ru.job4j.convert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс для конвертации двумерного массива в ArrayList и наоборот.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class ConvertList {

    /**
     * Метод для конвертации двумерного массива в ArrayList.
     * @param array двумерный массив.
     * @return список значений.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] arr : array) {
            for (int item : arr) {
                list.add(item);
            }
        }
        return list;
    }

    /**
     * Метод для конвертации списка в двумерный массив.
     * @param list список целочисленных значений.
     * @param rows количество строк.
     * @return целочисленный двумерный массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] array = new int[rows][(int) Math.ceil((double) list.size() / rows)];
        //int zeroNumber = (list.size() / rows) - (list.size() % rows);
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (iterator.hasNext()) {
                    array[i][j] = iterator.next();
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }
}
