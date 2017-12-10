package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для класса SimpleQueue.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class SimpleQueueTest {

    /**
     * Поле для структуры данных.
     */
    private SimpleQueue<Integer> sq;

    /**
     * Метод для создания структуры данных перед запуском тестов.
     */
    @Before
    public void setUp() {
        sq = new SimpleQueue<>();
        for (int i = 0; i < 3; i++) {
            sq.push(i);
        }
    }

    /**
     * Тест для методов push и poll.
     * Метод должен добавить, удалить элементы и вывести ожидаемый элемент.
     */
    @Test
    public void whenPushAndPollElementsThenArrayHasNextElement() {
        for (int i = 3; i < 10; i++) {
            sq.push(i);
        }
        for (int i = 0; i < 9; i++) {
            sq.poll();
        }
        assertThat(sq.poll(), is(9));
    }

    /**
     * Тест для методов push и poll.
     * Метод должен добавить, удалить элемент.
     */
    @Test
    public void whenPushAndPollOneElementThenNoExceptions() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        int i = queue.poll();
        assertThat(i, is(1));
    }
}