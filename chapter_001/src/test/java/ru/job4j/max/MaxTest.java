package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса Max.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class MaxTest {

    /**
     * Тест для метода max.
     * Должен вернуть 5 как маскимальное из чисел 2 и 5.
     */
    @Test
    public void whenTwoAndFiveThenFive() {
        Max objectMax = new Max();
        int expected = 5;
        int result = objectMax.max(2, 5);
        assertThat(result, is(expected));
    }
}
