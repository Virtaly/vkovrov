package ru.job4j.list;

/**
 * Класс для описания очереди (First Input First Output).
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <T> тип хранимых в стэке объектов.
 */
public class SimpleQueue<T> {

    /**
     * Поле для связного списка.
     */
    private LinkedArray<T> queue;

    /**
     * Конструктор класса.
     */
    public SimpleQueue() {
        this.queue = new LinkedArray<>();
    }

    /**
     * Метод для извлечения первого элемента из очереди с удалением.
     * @return первый элемент.
     */
    public T poll() {
        return queue.remove(queue.getFirst());
    }

    /**
     * Метод для добления элемента в конец очереди.
     * @param value элемент.
     */
    public void push(T value) {
        queue.add(value);
    }
}
