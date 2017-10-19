package ru.job4j.tracker;

/**
 * Класс Comments для описания массива комментариев к заявке.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Comments {

    /**
     * Массив для комментариев.
     */
    private String[] comments;

    /**
     * Поле для позиции, в которую будет записываться следующий комментарий.
     */
    private int commentsPosition = 0;

    /**
     * Конструктор для класса Comments.
     */
    public Comments() {
        comments = new String[10];
    }

    /**
     * Метод для добавления комментария в массив комментариев.
     * @param comment комментарий.
     */
    public void addComment(String comment) {
        if (commentsPosition < 10) {
            comments[commentsPosition++] = comment;
        }
    }

    /**
     * Геттер для массива комментариев.
     * @return массив комментариев.
     */
    public String[] getComments() {
        return this.comments;
    }
}
