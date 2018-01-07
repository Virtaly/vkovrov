package ru.job4j.threads;

import org.junit.Before;
import org.junit.Test;

/**
 * Тест для класса CounterTest.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class CounterTest {

    /**
     * Поле для счетчика.
     */
    private Counter parallelCounter;

    /**
     * Метод для создания счетчика перед запуском тестов.
     */
    @Before
    public void setUp() {
        parallelCounter = new Counter();
    }

    /**
     * Тест для метода count.
     */
    @Test
    public void whenCountWordsAndSpacesThenCountParallel() {
        parallelCounter.count("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
    }

}