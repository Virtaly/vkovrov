package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для класса SimpleLinkedSet.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class SimpleLinkedSetTest {

    /**
     * Поле для структуры данных.
     */
    private SimpleLinkedSet<Integer> sls;

    /**
     * Метод для создания структуры данных перед запуском тестов.
     */
    @Before
    public void setUp() {
        sls = new SimpleLinkedSet<>();
        for (int i = 0; i < 3; i++) {
            sls.add(i + 1);
        }
        for (int i = 0; i < 3; i++) {
            sls.add(i + 1);
        }
    }

    /**
     * Тест для методов next() и hasNext().
     * Должен пройти все проверки.
     */
    @Test
    public void shouldReturnExceptionAfterPassedTests() {
        assertThat(sls.hasNext(), is(true));
        assertThat(sls.hasNext(), is(true));
        assertThat(sls.hasNext(), is(true));
        assertThat(sls.hasNext(), is(true));
        assertThat(sls.next(), is(1));
        assertThat(sls.hasNext(), is(true));
        assertThat(sls.hasNext(), is(true));
        assertThat(sls.next(), is(2));
        assertThat(sls.hasNext(), is(true));
        assertThat(sls.hasNext(), is(true));
        assertThat(sls.next(), is(3));
        assertThat(sls.hasNext(), is(false));
        assertThat(sls.hasNext(), is(false));
    }

    /**
     * Тест для методов add и next.
     * Метод должен добавить элементы, вывести ожидаемый элемент и выкинуть исключения отсутствия элемента.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenAddElementsThenArrayHasTheseElements() {
        for (int i = 3; i < 20; i++) {
            sls.add(i + 1);
        }
        int i = 1;
        while (sls.hasNext()) {
            assertThat(sls.next(), is(i++));
        }
        sls.next();
    }
}