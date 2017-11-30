package ru.job4j.iteration;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для класса PrimeIterator.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class PrimeIteratorTest {

    /**
     * Поле для итератора.
     */
    private Iterator<Integer> it;

    /**
     * Метод для создания итератора перед запуском тестов.
     */
    @Before
    public void setUp() {
        it = new PrimeIterator(new int[]{1, 2, 3, 4, 5, 6, 7, 3571});
    }

    /**
     * Тест для методов next() и hasNext().
     * Должен пройти все проверки и в конце выбросить исключение отсутствия следующего элемента.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnPrimeNumbersOnly() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3571));
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
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(3571));
    }

    /**
     * Тест для метода hasNext().
     * Должен вернуть false так как нет элементов простых чисел.
     */
    @Test
    public void shouldReturnFalseCauseThereIsNoAnyPrimeNumber() {
        it = new PrimeIterator(new int[]{4, 6});
        assertThat("should return false, cause there is no any prime number", it.hasNext(), is(false));
    }

}