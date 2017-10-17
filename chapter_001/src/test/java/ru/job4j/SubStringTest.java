package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса SubString.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */

public class SubStringTest {

    /**
     * Тест для метода contains.
     * Метод должен вернуть true, т.к. в строке есть заданная подстрока.
     */
    @Test
    public void whenOneStringContainsAnotherOneThenTrue() {
        SubString subString = new SubString();
        boolean expected = true;
        boolean result = subString.contains("Привет", "ве");
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода contains.
     * Метод должен вернуть false, т.к. в строке нет заданной подстроки.
     */
    @Test
    public void whenOneStringDoesNotContainAnotherOneThenFalse() {
        SubString subString = new SubString();
        boolean expected = false;
        boolean result = subString.contains("Привет", "Пре");
        assertThat(result, is(expected));
    }
}