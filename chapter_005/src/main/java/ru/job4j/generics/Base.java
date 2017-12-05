package ru.job4j.generics;

/**
 * Класс для описания абстрактной модели.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public abstract class Base {

    /**
     * Поле для идентификатора.
     */
    private String id;

    /**
     * Поле для имени.
     */
    private String name;

    /**
     * Конструктор класса.
     * @param id идентификатор.
     * @param name имя.
     */
    public Base(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Геттер для идентификатора.
     * @return идентификатор.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Метод для сравнения двух объектов.
     * @param o объект для сравнения.
     * @return равны ли объекты.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Base base = (Base) o;

        if (id != null ? !id.equals(base.id) : base.id != null) {
            return false;
        }
        return name != null ? name.equals(base.name) : base.name == null;
    }

    /**
     * Метод для вычисления хешкода объекта.
     * @return хешкод объекта.
     */
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
