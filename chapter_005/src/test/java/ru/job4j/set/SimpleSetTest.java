package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для класса SimpleSet.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */

public class SimpleSetTest {
    /**
     * Поле для структуры данных.
     */
    private SimpleSet<Integer> ss;

    /**
     * Метод для создания структуры данных перед запуском тестов.
     */
    @Before
    public void setUp() {
        ss = new SimpleSet<>();
        for (int i = 0; i < 4; i++) {
            ss.add(i + 1);
        }
        for (int i = 0; i < 4; i++) {
            ss.add(i + 1);
        }
    }

    /**
     * Тест для методов next() и hasNext().
     * Должен пройти все проверки и в конце выбросить исключение отсутствия следующего элемента.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        assertThat(ss.hasNext(), is(true));
        assertThat(ss.next(), is(1));
        assertThat(ss.hasNext(), is(true));
        assertThat(ss.next(), is(2));
        assertThat(ss.hasNext(), is(true));
        assertThat(ss.next(), is(3));
        assertThat(ss.hasNext(), is(true));
        assertThat(ss.next(), is(4));
        assertThat(ss.hasNext(), is(false));
        ss.next();
    }

    /**
     * Тест для методов add и next.
     * Метод должен добавить элементы, автоматически увеличив размер контейнера,
     * и вывести ожидаемый элемент.
     */
    @Test
    public void whenAddThreeElementsThenArrayHasSixthElement() {
        for (int i = 4; i < 20; i++) {
            ss.add(i + 1);
        }
        for (int i = 0; i < 19; i++) {
            ss.next();
        }
        assertThat(ss.next(), is(20));
    }
}