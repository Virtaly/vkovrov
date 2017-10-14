package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса BubbleSort.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class BubbleSortTest {

    /**
     * Тест для метода sort.
     * Метод принимает массив и должен вернуть его в отсортированном виде.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubble = new BubbleSort();
        int[] result = bubble.sort(new int[]{1, 5, 4, 2, 3, 1, 7, 8, 0, 5});
        int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, is(expected));
    }

}
