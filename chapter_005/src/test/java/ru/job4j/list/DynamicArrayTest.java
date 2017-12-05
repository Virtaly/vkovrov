package ru.job4j.list;

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
public class DynamicArrayTest {

    /**
     * Поле для структуры данных.
     */
    private DynamicArray<Integer> da;

    /**
     * Поле для итератора.
     */
    private Iterator<Integer> it;

    /**
     * Метод для создания итератора перед запуском тестов.
     */
    @Before
    public void setUp() {
        da = new DynamicArray<>();
        for (int i = 0; i < 3; i++) {
            da.add(i);
        }
        it = da.iterator();
    }

    /**
     * Тест для методов next() и hasNext().
     * Должен пройти все проверки и в конце выбросить исключение отсутствия следующего элемента.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(0));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * Тест для методов add и get.
     * Метод должен добавить элементы, автоматически увеличив размер контейнера,
     * и вывести ожидаемый элемент.
     */
    @Test
    public void whenAddThreeElementsThenArrayHasSixthElement() {
        //изначальный размер контейнера 10.
        for (int i = 3; i < 20; i++) {
            da.add(i);
        }
        assertThat(da.get(19), is(19));
    }
}