package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для класса LinkedArray.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class LinkedArrayTest {

    /**
     * Поле для структуры данных.
     */
    private LinkedArray<Integer> da;

    /**
     * Поле для итератора.
     */
    private Iterator<Integer> it;

    /**
     * Метод для создания структуры данных и итератора перед запуском тестов.
     */
    @Before
    public void setUp() {
        da = new LinkedArray<>();
        for (int i = 0; i < 3; i++) {
            da.add(i + 1);
        }
        it = da.iterator();
    }

    /**
     * Тест для методов next() и hasNext().
     * Должен пройти все проверки и в конце выбросить исключение отсутствия следующего элемента.
     */
    @Test
    public void shouldReturnExceptionAfterPassedTests() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Тест для методов add и get.
     * Метод должен добавить элементы и вывести ожидаемый элемент.
     */
    @Test (expected = IllegalArgumentException.class)
    public void whenAddElementsThenArrayHasTheseElements() {
        for (int i = 3; i < 20; i++) {
            da.add(i + 1);
        }
        assertThat(da.get(5), is(6));
        da.get(25);
    }
}