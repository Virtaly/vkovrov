package ru.job4j.convert;

/**
 * Класс для пользователя.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class User {

    /**
     * Поле для идентификатора.
     */
    private int id;

    /**
     * Поле для имени.
     */
    private String name;

    /**
     * Поле для города.
     */
    private String city;

    /**
     * Конструктор класса.
     * @param id идентификатор.
     * @param name имя.
     * @param city город.
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Геттер для идентификатора.
     * @return идентификатор.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Геттер для имени.
     * @return имя.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Геттер для города.
     * @return город.
     */
    public String getCity() {
        return this.city;
    }
}
