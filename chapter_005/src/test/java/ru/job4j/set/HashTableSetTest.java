package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для класса HashTableSet.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class HashTableSetTest {

    /**
     * Поле для структуры данных.
     */
    private HashTableSet<Integer> hts;

    /**
     * Метод для создания структуры данных перед запуском тестов.
     */
    @Before
    public void setUp() {
        hts = new HashTableSet<>();
        for (int i = 0; i < 3; i++) {
            hts.add(i + 1);
        }
        for (int i = 0; i < 3; i++) {
            hts.add(i + 1);
        }
    }

    /**
     * Тест для метода remove.
     * Метод должен удалить элементы.
     */
    @Test
    public void whenRemoveElementsThenArrayHasntTheseElements() {
        for (int i = 0; i < 3; i++) {
            assertThat(hts.remove(i + 1), is(true));
        }
        for (int i = 0; i < 20; i++) {
            assertThat(hts.contains(i + 1), is(false));
        }
    }

    /**
     * Тест для методов add и contains.
     * Метод должен добавить элементы, увеличив емкость контейнера.
     */
    @Test
    public void whenAddElementsThenArrayHasTheseElements() {
        for (int i = 3; i < 20; i++) {
            assertThat(hts.add(i + 1), is(true));
        }
        for (int i = 0; i < 20; i++) {
            assertThat(hts.contains(i + 1), is(true));
        }
    }
}