package ru.job4j.nonblocking;

/**
 * Класс для акции.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Model {

    /**
     * Поле для идентификатора.
     */
    private int key;

    /**
     * Поле для имени.
     */
    private String name;

    /**
     * Версия обновления.
     */
    private volatile int version;

    /**
     * Конструктор класса.
     * @param key идентификатор.
     * @param name имя.
     */
    public Model(int key, String name) {
        this.name = name;
        this.key = key;
        this.version = 1;
    }

    /**
     * Геттер для имени.
     * @return имя.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Сеттер для имени.
     * @param name имя.
     */
    public void setName(String name) {
        this.name = name;
        this.version++;
    }

    /**
     * Геттер для идентификатора.
     * @return иидентификатор.
     */
    public int getKey() {
        return key;
    }

    /**
     * Геттер для версии обновления.
     * @return версия обновления.
     */
    public int getVersion() {
        return this.version;
    }

    /**
     * Метод для увеличения версии обновления.
     */
    public void incrementVersion() {
        this.version++;
    }
}
