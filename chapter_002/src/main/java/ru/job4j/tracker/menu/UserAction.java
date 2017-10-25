package ru.job4j.tracker.menu;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

/**
 * Интерфейс для действий пользователя.
 */
public interface UserAction {
    /**
     * Геттер для индекса действия в массиве действий.
     * @return индекс действия в массиве действий.
     */
    String getKey();

    /**
     * Метод для выполнения действия пользователя.
     * @param tracker трекер задач.
     * @param input объект для взаимодействия с пользователем.
     */
    void execute(Tracker tracker, Input input);

    /**
     * Геттер для информации о действии пользователя.
     * @return информация о действии пользователя
     */
    String getInfo();
}
