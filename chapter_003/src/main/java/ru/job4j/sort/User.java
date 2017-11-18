package ru.job4j.sort;

/**
 * Класс для пользователя.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class User implements Comparable<User> {

    /**
     * Поле для имени.
     */
    private String name;

    /**
     * Поле для возраста.
     */
    private int age;

    /**
     * Конструктор класса.
     * @param name имя.
     * @param age возраст.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Метод для сравнения объектов пользователей по возрасту.
     * @param user пользователь.
     * @return результат сравнения объектов.
     */
    @Override
    public int compareTo(User user) {
        return Integer.compare(this.age, user.age) == 0
                ? this.name.compareTo(user.name) : Integer.compare(this.age, user.age);
    }

    /**
     * Метод для строкового представления объекта.
     * @return строковое представление объекта.
     */
    @Override
    public String toString() {
        return String.format("%s is %d", this.name, this.age);
    }

    /**
     * Геттер для имени.
     * @return имя.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Геттер для возраста.
     * @return возраст.
     */
    public int getAge() {
        return this.age;
    }
}
