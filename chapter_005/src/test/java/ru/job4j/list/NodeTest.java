package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для класса Node.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class NodeTest {

    /**
     * Поле для структуры данных.
     */
    private Node<Integer> firstNode;

    /**
     * Метод для создания структуры данных перед запуском тестов.
     */
    @Before
    public void setUp() {
        firstNode = new Node<>(0);
    }

    /**
     * Тест для метода hasCycle.
     * Метод должен вернуть false, т.к. в списке нет замыканий.
     */
    @Test
    public void whenCheckForCycleThenFalse() {
        Node<Integer> secondNode = new Node<>(1);
        firstNode.setNext(secondNode);
        Node<Integer> thirdNode = new Node<>(2);
        secondNode.setNext(thirdNode);
        Node<Integer> fourthNode = new Node<>(3);
        thirdNode.setNext(fourthNode);
        Node<Integer> fifthNode = new Node<>(4);
        fourthNode.setNext(fifthNode);
        Node<Integer> sixthNode = new Node<>(5);
        fifthNode.setNext(sixthNode);
        assertThat(firstNode.hasCycle(), is(false));
    }

    /**
     * Тест для метода hasCycle.
     * Метод должен вернуть true, т.к. список зациклен.
     */
    @Test
    public void whenCheckForCycleThenTrueListCycled() {
        Node<Integer> secondNode = new Node<>(10);
        firstNode.setNext(secondNode);
        Node<Integer> thirdNode = new Node<>(20);
        secondNode.setNext(thirdNode);
        Node<Integer> fourthNode = new Node<>(30);
        thirdNode.setNext(fourthNode);
        Node<Integer> fifthNode = new Node<>(40);
        fourthNode.setNext(fifthNode);
        Node<Integer> sixthNode = new Node<>(50);
        fifthNode.setNext(sixthNode);
        sixthNode.setNext(firstNode);
        assertThat(firstNode.hasCycle(), is(true));
    }

    /**
     * Тест для метода hasCycle.
     * Метод должен вернуть true, т.к. в списке есть петля.
     */
    @Test
    public void whenCheckForCycleThenTrueListHasCycle() {
        Node<Integer> secondNode = new Node<>(100);
        firstNode.setNext(secondNode);
        Node<Integer> thirdNode = new Node<>(200);
        secondNode.setNext(thirdNode);
        Node<Integer> fourthNode = new Node<>(300);
        thirdNode.setNext(fourthNode);
        Node<Integer> fifthNode = new Node<>(400);
        fourthNode.setNext(secondNode);
        Node<Integer> sixthNode = new Node<>(500);
        fifthNode.setNext(sixthNode);
        assertThat(firstNode.hasCycle(), is(true));
    }
}