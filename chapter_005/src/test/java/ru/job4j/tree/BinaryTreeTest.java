package ru.job4j.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для класса BinaryTree.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class BinaryTreeTest {

    /**
     * Поле для структуры данных.
     */
    private BinaryTree<Integer> bt;

    /**
     * Поле для итератора структуры данных.
     */
    private Iterator<Integer> it;

    /**
     * Метод для создания структуры данных перед запуском тестов.
     */
    @Before
    public void setUp() {
        bt = new BinaryTree<>();
        for (int i = 0; i < 3; i++) {
            bt.add(i + 1);
        }
        for (int i = 0; i < 3; i++) {
            bt.add(i + 1);
        }
        it = bt.iterator();
    }

    /**
     * Тест для метода find и remove.
     * Методы должны найти и удалить элементы.
     */
    @Test
    public void whenRemoveElementsThenArrayHasntTheseElements() {
        for (int i = 0; i < 3; i++) {
            assertThat(bt.find(i + 1).getValue(), is(i + 1));
        }
    }

    /**
     * Тест для методов next() и hasNext().
     * Должен пройти все проверки.
     */
    @Test
    public void shouldReturnExceptionAfterPassedTests() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Тест для методов add и next.
     * Метод должен добавить элементы, вывести ожидаемый элемент и выкинуть исключения отсутствия элемента.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenAddElementsThenArrayHasTheseElements() {
        for (int i = 3; i < 20; i++) {
            bt.add(i + 1);
        }
        int i = 1;
        while (it.hasNext()) {
            assertThat(it.next(), is(i++));
        }
        it.next();
    }
}