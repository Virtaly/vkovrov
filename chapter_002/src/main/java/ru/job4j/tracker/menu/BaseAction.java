package ru.job4j.tracker.menu;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

/**
 * Абстрактный класс для описания действий пользователя.
 */
public abstract class BaseAction implements UserAction {

    /**
     * Номер пункта меню.
     */
    private String key;

    /**
     * Название пункта меню.
     */
    private String name;

    /**
     * Конструктор класса.
     * @param key номер пункта меню.
     * @param name название пункта меню.
     */
    public BaseAction(String key, String name) {
        this.key = key;
        this.name = name;
    }
    /**
     * Геттер для индекса действия в массиве действий.
     * @return индекс действия в массиве действий.
     */
    public abstract String getKey();

    /**
     * Метод для выполнения действия пользователя.
     * @param tracker трекер задач.
     * @param input объект для взаимодействия с пользователем.
     */
    public abstract void execute(Tracker tracker, Input input);

    /**
     * Геттер для информации о действии пользователя.
     * @return информация о действии пользователя
     */
    public String getInfo() {
        return String.format("%s. %s", this.key, this.name);
    }
}
