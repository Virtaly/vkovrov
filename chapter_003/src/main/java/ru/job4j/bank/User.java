package ru.job4j.bank;

/**
 * Класс для описания пользователя.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class User {

    /**
     * Поле для имени пользователя.
     */
    private String name;

    /**
     * Поле для номера паспорта.
     */
    private int passport;

    /**
     * Конструктор класса.
     * @param name имя пользователя.
     * @param passport номер паспорта.
     */
    public User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Метод для сравнения двух объектов.
     * @param o объект для сравнения с текущим.
     * @return равенство объектов.
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

        if (passport != user.passport) {
            return false;
        }
        return name != null ? name.equals(user.name) : user.name == null;
    }

    /**
     * Метод для вычисления хеш-кода объекта.
     * @return хеш-код объекта.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + passport;
        return result;
    }

    /**
     * Метод для строкового представления объекта.
     * @return строка, описывающая объект.
     */
    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", passport=" + passport
                + '}';
    }
}
