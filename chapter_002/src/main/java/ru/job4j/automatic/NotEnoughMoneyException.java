package ru.job4j.automatic;

/**
 * Класс для исключения нехватки денег для оплаты.
 */
public class NotEnoughMoneyException extends RuntimeException {

    /**
     * Конструктор для класса.
     */
    public NotEnoughMoneyException() {
        super("Not enough money!");
    }

}
