package ru.job4j.tracker.menu;

/**
 * Класс MenuOutException для обработки исключений выхода за границы меню.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class MenuOutException extends RuntimeException {
    /**
     * Конструктор класса.
     * @param msg текстовое сообщение.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
