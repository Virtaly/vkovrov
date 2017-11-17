package ru.job4j.convert;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса ConvertList.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class ConvertListTest {

    /**
     * Тест для метода toList.
     * Метод должен вернуть список со всеми элементами двумерного массива.
     */
    @Test
    public void whenConvertArrayToListThenArrayListWithIntegerElements() {
        ConvertList converter = new ConvertList();
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = converter.toList(array);
        boolean result = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (!list.contains(array[i][j])) {
                    result = false;
                }
            }
        }
        assertThat(result, is(true));

    }

    /**
     * Тест для метода toArray.
     * Метод должен вернуть двумерный массив со всеми элементами списка.
     */
    @Test
    public void whenConvertListToArrayThenArrayWithIntegerElements() {
        ConvertList converter = new ConvertList();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            list.add(i);
        }
        int[][] result = converter.toArray(list, 3);
        int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода convert.
     * Метод должен вернуть список со всеми элементами массивов.
     */
    @Test
    public void whenConvertListOfArraysToIntegerListThenListWithAllElementsOfArrays() {
        ConvertList converter = new ConvertList();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new int[i + 1]);
            for (int j = 0; j < list.size(); j++) {
                list.get(i)[j] = j;
            }
        }
        List<Integer> result = converter.convert(list);
        int[] expected = {0, 0, 1, 0, 1, 2};
        assertThat(result.toArray(), is(expected));
    }
}