package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для класса HashTableSetChain.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class HashTableSetChainTest {

    /**
     * Поле для структуры данных.
     */
    private HashTableSetChain<Integer> htsc;

    /**
     * Метод для создания структуры данных перед запуском тестов.
     */
    @Before
    public void setUp() {
        htsc = new HashTableSetChain<>();
        for (int i = 0; i < 3; i++) {
            htsc.add(i + 1);
        }
        for (int i = 0; i < 3; i++) {
            htsc.add(i + 1);
        }
    }

    /**
     * Тест для метода remove.
     * Метод должен удалить элементы.
     */
    @Test
    public void whenRemoveElementsThenArrayHasntTheseElements() {
        for (int i = 0; i < 3; i++) {
            assertThat(htsc.remove(i + 1), is(true));
        }
        for (int i = 0; i < 20; i++) {
            assertThat(htsc.contains(i + 1), is(false));
        }
    }

    /**
     * Тест для методов add и contains.
     * Метод должен добавить элементы, увеличив емкость контейнера.
     */
    @Test
    public void whenAddElementsThenArrayHasTheseElements() {
        for (int i = 3; i < 20; i++) {
            assertThat(htsc.add(i + 1), is(true));
        }
        for (int i = 0; i < 20; i++) {
            assertThat(htsc.contains(i + 1), is(true));
        }
    }
}