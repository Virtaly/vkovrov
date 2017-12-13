package ru.job4j.map;

import java.util.Calendar;

/**
 * Класс для описания пользователя.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class User {

    /**
     * Поле для имени.
     */
    private String name;

    /**
     * Поле для количества детей.
     */
    private int children;

    /**
     * Поле для дня рождения.
     */
    private Calendar birthday;

    /**
     * Конструктор класса.
     * @param name имя.
     * @param children количество детей.
     * @param birthday день рождения.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Метод для определения идентичности объектов.
     * @param o объект для сравнения.
     * @return идентичны ли объекты.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (children != user.children) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }

    /**
     * Метод для вычисления хеш-кода объекта.
     * @return хеш-код объекта.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
