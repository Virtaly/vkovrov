package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для класса SimpleHashMap.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class SimpleHashMapTest {
    /**
     * Поле для структуры данных.
     */
    private SimpleHashMap<Integer, String> shm;

    /**
     * Поле для итератора структуры данных.
     */
    private Iterator<SimpleHashMap.Couple> it;

    /**
     * Метод для создания структуры данных перед запуском тестов.
     */
    @Before
    public void setUp() {
        shm = new SimpleHashMap<>();
        for (int i = 0; i < 3; i++) {
            shm.insert(i + 1, "first");
        }
        for (int i = 0; i < 3; i++) {
            shm.insert(i + 1, "second");
        }
        it = shm.iterator();
    }

    /**
     * Тест для метода remove.
     * Метод должен удалить элементы.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenRemoveElementsThenArrayHasntTheseElements() {
        for (int i = 0; i < 3; i++) {
            assertThat(shm.delete(i + 1), is(true));
        }
        shm.get(1);
    }

    /**
     * Тест для методов add и contains.
     * Метод должен добавить элементы, увеличив емкость контейнера.
     */
    @Test
    public void whenAddElementsThenArrayHasTheseElements() {
        for (int i = 3; i < 20; i++) {
            assertThat(shm.insert(i + 1, "third"), is(true));
        }
        for (int i = 0; i < 3; i++) {
            assertThat(shm.get(i + 1), is("first"));
        }
        for (int i = 3; i < 20; i++) {
            assertThat(shm.get(i + 1), is("third"));
        }
    }

    /**
     * Тест для методов hasNext() и next().
     * Методы должны корректно отработать.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenIterateOverElementsThenExpectedResult() {
        for (int i = 0; i < 10; i++) {
            assertThat(it.hasNext(), is(true));
        }
        assertThat(it.next().getKey(), is(1));
        assertThat(it.next().getKey(), is(2));
        for (int i = 0; i < 10; i++) {
            assertThat(it.hasNext(), is(true));
        }
        assertThat(it.next().getKey(), is(3));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}