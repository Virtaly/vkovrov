package ru.job4j.nonblocking;

/**
 * Класс для исключения.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class OplimisticException extends Exception {

    /**
     * Конструктор класса.
     * @param message сообщение об ошибке.
     */
    public OplimisticException(String message) {
        super(message);
    }
}
