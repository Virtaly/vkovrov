package ru.job4j.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для класса MultiPathTree.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class MultiPathTreeTest {

    /**
     * Поле для структуры данных.
     */
    private MultiPathTree<Integer> tree;

    /**
     * Поле для итератора структуры данных.
     */
    private Iterator<Integer> it;

    /**
     * Метод для создания структуры данных перед запуском тестов.
     */
    @Before
    public void setUp() {
        tree = new MultiPathTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        it = tree.iterator();
    }

    /**
     * Тест для метода find().
     */
    @Test
    public void when6ElFindLastThen6() {
        assertThat(tree.find(6).isPresent(), is(true));
    }

    /**
     * Тест для метода find().
     */
    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        assertThat(tree.find(7).isPresent(), is(false));
    }

    /**
     * Тест для методов next() и hasNext().
     * Должен пройти все проверки.
     */
    @Test
    public void shouldReturnExceptionAfterPassedTests() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Тест для метода isBinary.
     * Должен вывести вернуть true, т.к. дерево бинарное.
     */
    @Test
    public void shouldBeBinaryTree() {
        MultiPathTree<Integer> binaryTree = new MultiPathTree<>(1);
        binaryTree.add(1, 2);
        binaryTree.add(1, 3);
        binaryTree.add(2, 4);
        binaryTree.add(2, 5);
        binaryTree.add(3, 6);
        binaryTree.add(6, 7);
        assertThat(binaryTree.isBinary(), is(true));
    }

    /**
     * Тест для метода isBinary.
     * Должен вывести вернуть false, т.к. дерево не бинарное.
     */
    @Test
    public void shouldBeNotBinaryTree() {
        MultiPathTree<Integer> binaryTree = new MultiPathTree<>(1);
        binaryTree.add(1, 2);
        binaryTree.add(1, 3);
        binaryTree.add(2, 4);
        binaryTree.add(2, 5);
        binaryTree.add(3, 6);
        binaryTree.add(3, 7);
        binaryTree.add(3, 8);
        assertThat(binaryTree.isBinary(), is(false));
    }
}