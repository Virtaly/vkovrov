package ru.job4j.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

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
        bt.add(50);
        bt.add(70);
        bt.add(30);
        bt.add(20);
        bt.add(40);
        bt.add(80);
        bt.add(60);
        bt.add(70);
        bt.add(100);
        bt.add(100);
        it = bt.iterator();
    }

    /**
     * Тест для метода find и remove.
     * Методы должны найти и удалить элементы.
     */
    @Test
    public void whenFindElementsThenTreeHasTheseElements() {
        assertThat(bt.find(50).getValue(), is(50));
        assertThat(bt.find(70).getValue(), is(70));
        assertThat(bt.find(30).getValue(), is(30));
        assertThat(bt.find(20).getValue(), is(20));
        assertThat(bt.find(40).getValue(), is(40));
        assertThat(bt.find(80).getValue(), is(80));
        assertThat(bt.find(60).getValue(), is(60));
        assertThat(bt.find(100).getValue(), is(100));
    }

    /**
     * Тест для методов next() и hasNext().
     * Должен пройти все проверки.
     */
    @Test
    public void shouldPassAllTests() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(50));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(30));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(70));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(20));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(40));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(60));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(80));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(100));
        assertThat(it.hasNext(), is(false));
    }
}