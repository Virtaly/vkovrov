package ru.job4j.list;

/**
 * Класс для описания узла.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <T> тип хранимых в узле данных.
 */
public class Node<T> {

    /**
     * Поле для данных.
     */
    private T value;

    /**
     * Поле для ссылки на следующий узел.
     */
    private Node<T> next;

    /**
     * Конструктор класса.
     * @param value данные.
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Геттер для данных, хранимых в узле.
     * @return данные, хранимые в узле.
     */
    public T getValue() {
        return value;
    }

    /**
     * Cеттер для данных, хранимых в узле.
     * @param value данные, хранимые в узле.
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Геттер для следующего узла.
     * @return следующий узел.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Cеттер для следующего узла.
     * @param next следующий узел.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Метод для проверки списка узлов на наличие петель.
     * @return есть ли замыкания в списке.
     */
    boolean hasCycle() {
        Node<T> slowRunner = this;
        Node<T> fastRunner = this;
        boolean isCycle = false;
        while (fastRunner != null && fastRunner.getNext() != null) {
            slowRunner = slowRunner.getNext();
            fastRunner = fastRunner.getNext().getNext();
            if (slowRunner == fastRunner) {
                isCycle = true;
                break;
            }

        }
        return isCycle;
    }
}
