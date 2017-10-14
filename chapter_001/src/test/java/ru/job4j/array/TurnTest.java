package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса Turn.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class TurnTest {

    /**
     * Тест для метода back.
     * Метод принимает массив с нечетным количеством элементом и должен вернуть массив в обратном порядке.
     */
    @Test
    public void whenTurnArrayWithOddCountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] expected = {5, 4, 3, 2, 1};
        int[] result = turn.back(new int[]{1, 2, 3, 4, 5});
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода back.
     * Метод принимает массив с четеным количеством элементом и должен вернуть массив в обратном порядке.
     */
    @Test
    public void whenTurnArrayWithEvenCountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] expected = {6, 5, 4, 3, 2, 1};
        int[] result = turn.back(new int[]{1, 2, 3, 4, 5, 6});
        assertThat(result, is(expected));
    }
}
