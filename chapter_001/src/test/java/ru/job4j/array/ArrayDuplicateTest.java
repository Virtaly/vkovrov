package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса ArrayDuplicate.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */

public class ArrayDuplicateTest {
    /**
     * Тест для метода remove.
     * Метод принимает массив с дубликатами и должен вернуть его без дубликатов.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrDuplicate = new ArrayDuplicate();
        String[] result = arrDuplicate.remove(new String[] {"Привет", "Мир", "Привет", "Супер", "Мир"});
        String[] expected = {"Привет", "Мир", "Супер"};
        assertThat(result, is(expected));
    }
}