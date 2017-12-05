package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса SimpleArray.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class SimpleArrayTest {

    /**
     * Поле для коллекции.
     */
    private SimpleArray<Integer> sa;

    /**
     * Метод для создания коллекции перед запуском тестов.
     */
    @Before
    public void setUp() {
        sa = new SimpleArray<>(10);
        sa.add(1);
        sa.add(2);
        sa.add(3);
    }


    /**
     * Тест для метода add.
     * Метод должен добавить три элемента.
     */
    @Test
    public void whenAddThreeElementsThenArrayHasSixthElement() {
        sa.add(4);
        sa.add(5);
        sa.add(6);
        assertThat(sa.get(5), is(6));
    }

    /**
     * Тест для метода update.
     * Метод должен обновить третий элемент.
     */
    @Test
    public void whenUpdateElementThenArrayHasThisElement() {
        sa.update(2, 10);
        assertThat(sa.get(2), is(10));
    }

    /**
     * Тест для метода delete.
     * Метод должен удалить первый элемент.
     */
    @Test
    public void whenDeleteElementThenArrayHasntThisElement() {
        sa.delete(0);
        assertThat(sa.get(0), is(2));
    }

}