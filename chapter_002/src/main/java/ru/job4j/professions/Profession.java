package ru.job4j.professions;

/**
 * Класс Profession класс-родитель для всех профессий, содержит общие данные и методы.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Profession {
    /**
     * Поле для названия узкой специализации.
     */
    private String specialization;

    /**
     * Поле для зарплаты.
     */
    private int salary;

    /**
     * Конструктор класса.
     * @param spec узкая специализация.
     * @param salary зарплата.
     */
    public Profession(String spec, int salary) {
        this.specialization = spec;
        this.salary = salary;
    }

    /**
     * Геттер для поля specialization.
     * @return узкая специализация.
     */
    public String getSpecialization() {
        return this.specialization;
    }

    /**
     * Геттер для поля salary.
     * @return зарплата.
     */
    public int getSalary() {
        return this.salary;
    }
}
