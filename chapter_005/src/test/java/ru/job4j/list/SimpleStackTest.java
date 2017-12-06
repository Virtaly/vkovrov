package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для класса SimpleStack.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class SimpleStackTest {

    /**
     * Поле для структуры данных.
     */
    private SimpleStack<Integer> ss;

    /**
     * Метод для создания структуры данных перед запуском тестов.
     */
    @Before
    public void setUp() {
        ss = new SimpleStack<>();
        for (int i = 0; i < 3; i++) {
            ss.push(i);
        }
    }

    /**
     * Тест для методов push и poll.
     * Метод должен добавить, удалить элементы и вывести ожидаемый элемент.
     */
    @Test
    public void whenPushAndPollElementsThenArrayHasNextElement() {
        for (int i = 3; i < 10; i++) {
            ss.push(i);
        }
        for (int i = 3; i < 10; i++) {
            ss.poll();
        }
        assertThat(ss.poll(), is(2));
    }
}