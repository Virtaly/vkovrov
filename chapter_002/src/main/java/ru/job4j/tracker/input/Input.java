package ru.job4j.tracker.input;

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

    /**
     * Метод для взаимодействия с пользователем,
     * для версии с защитой от некорректного ввода.
     * @param question вопрос пользователю.
     * @param range диапазон значений меню.
     * @return ответ пользователя.
     */
    int ask(String question, int[] range);
}
