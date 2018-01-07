package ru.job4j.list;

/**
 * Класс для описания стека (First Input Last Output).
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <T> тип хранимых в стэке объектов.
 */
public class SimpleStack<T> {

    /**
     * Поле для связного списка.
     */
    private LinkedArray<T> stack;

    /**
     * Конструктор класса.
     */
    public SimpleStack() {
        this.stack = new LinkedArray<>();
    }

    /**
     * Метод для извлечения последнего элемента из стека с удалением.
     * @return последний элемент.
     */
    public T poll() {
        return stack.remove(stack.getLast().getData());
    }

    /**
     * Метод для добления элемента в конец стека.
     * @param value элемент.
     */
    public void push(T value) {
        stack.add(value);
    }
}
