package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса Factorial.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class FactorialTest {

    /**
     * Тест для метода calc.
     * Должен вычислить факториал числа 5 и вернуть 120.
     */
    @Test
    public void whenFiveThenFactorialOneHundredTwenty() {
        Factorial factorial = new Factorial();
        int expected = 120;
        int result = factorial.calc(5);
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода calc.
     * Должен вычислить факториал числа 0 и вернуть 1.
     */
    @Test
    public void whenZeroThenFactorialOne() {
        Factorial factorial = new Factorial();
        int expected = 1;
        int result = factorial.calc(0);
        assertThat(result, is(expected));
    }
}
