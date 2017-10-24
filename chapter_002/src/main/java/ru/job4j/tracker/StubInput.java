package ru.job4j.tracker;

/**
 * Класс StubInput заглушка для пользовательского ввода.
 */
public class StubInput implements Input {

    /**
     * Поле для массива ответов пользователя.
     */
    private String[] answers;

    /**
     * Поле для флага, указывающего на следующий ответ пользователя, который будет использоваться.
     */
    private int answersPosition = 0;

    /**
     * Конструктор для класса StubInput.
     * @param answers массив ответов пользователя.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Метод для эмуляции ответов пользователя на запросы приложения.
     * @param question вопрос пользователю, здесь не используется,
     * т.к. взаимодействие с пользователем не производится.
     * @return следующий по очереди ответ пользователя из массива ответов.
     */
    public String ask(String question) {
        return answers[answersPosition++];
    }
}
