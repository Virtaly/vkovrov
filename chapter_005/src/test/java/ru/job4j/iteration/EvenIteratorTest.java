package ru.job4j.iteration;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для класса EvenIterator.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class EvenIteratorTest {

    /**
     * Поле для итератора.
     */
    private Iterator<Integer> it;

    /**
     * Метод для создания итератора перед запуском тестов.
     */
    @Before
    public void setUp() {
        it = new EvenIterator(new int[]{1, 2, 3, 4, 5, 6, 7});
    }

    /**
     * Тест для методов next() и hasNext().
     * Должен пройти все проверки и в конце выбросить исключение отсутствия следующего элемента.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * Тест для методов next() и hasNext().
     * Должен пройти все проверки.
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
    }

    /**
     * Тест для методов hasNext().
     * Должен вернуть false так как нет четных элементов.
     */
    @Test
    public void  shouldReturnFalseIfNoAnyEvenNumbers() {
        it = new EvenIterator(new int[]{1});
        assertThat(it.hasNext(), is(false));
    }


}