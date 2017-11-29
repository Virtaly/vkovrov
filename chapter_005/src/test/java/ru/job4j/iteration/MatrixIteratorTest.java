package ru.job4j.iteration;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для класса TwoDimensionalIterator с использованием двумерного массива с массивами одинаковой длины.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class MatrixIteratorTest {

    /**
     * Поле для итератора.
     */
    private Iterator<Integer> it;

    /**
     * Метод для создания итератора перед запуском тестов.
     */
    @Before
    public void setUp() {
        it = new TwoDimensionalIterator<>(new Integer[][]{{1, 2, 3}, {4, 5, 6}});
    }

    /**
     * Тест для методов next() и hasNext().
     * Должен пройти все проверки и в конце выбросить исключение отсутствия следующего элемента.
     */
    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * Тест для метода next().
     * Должен пройти все проверки и в конце выбросить исключение отсутствия следующего элемента.
     */
    @Test(expected = NoSuchElementException.class)
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        it.next();
    }

    /**
     * Тест для методов next() и hasNext().
     * Должен пройти все проверки и в конце выбросить исключение отсутствия следующего элемента.
     */
    @Test(expected = NoSuchElementException.class)
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        it.next();
    }
}