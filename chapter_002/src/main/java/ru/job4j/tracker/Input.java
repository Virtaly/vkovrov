package ru.job4j.tracker;

/**
 * Интерфейс пользовательского ввода.
 */
public interface Input {
    /**
     * Метод для взаимодействия с пользователем.
     * @param question вопрос пользователю.
     * @return ответ пользователя.
     */
    String ask(String question);
}
