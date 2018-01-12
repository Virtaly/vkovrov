package ru.job4j.compare;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для класса CompareStrings.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class CompareStringsTest {

    /**
     * Поле для компаратора строк.
     */
    private CompareStrings cs;

    /**
     * Метод для создания компаратора перед запуском тестов.
     */
    @Before
    public void setUp() {
        cs = new CompareStrings();
    }

    /**
     * Тест для метода compare.
     * Должен вернуть true, если слова состоят из одинаковых букв.
     */
    @Test
    public void whenStringsContainSimilarCharsThenTrue() {
        String s1 = "programming";
        String s2 = "mignrgamrop";
        assertThat(cs.compare(s1, s2), is(true));
        s1 = "programmin";
        assertThat(cs.compare(s1, s2), is(false));
    }

    /**
     * Тест для метода compareStable.
     * Должен вернуть true, если слова состоят из одинаковых букв.
     */
    @Test
    public void whenStringsContainSimilarCharsThenTrueForStableMethod() {
        String s1 = "Programming";
        String s2 = "mignrgamroP";
        assertThat(cs.compareStable(s1, s2), is(true));
        s1 = "programming";
        assertThat(cs.compareStable(s1, s2), is(false));
    }
}