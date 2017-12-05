package ru.job4j.generics;

/**
 * Класс для описания модели пользователя.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class User extends Base {

    /**
     * Конструктор класса.
     * @param id идентификатор.
     * @param name имя.
     */
    public User(String id, String name) {
        super(id, name);
    }
}
