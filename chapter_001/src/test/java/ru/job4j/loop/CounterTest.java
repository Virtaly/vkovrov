package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса Counter.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class CounterTest {

    /**
     * Тест для метода add.
     * Должен вернуть 30 как результат сложения четных чисел в диапазоне от 1 до 10 включительно.
     */
    @Test
    public void whenStartOneAndFinishTenThenThirty() {
        Counter counter = new Counter();
        int expected = 30;
        int result = counter.add(1, 10);
        assertThat(result, is(expected));
    }
}
