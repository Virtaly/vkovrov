package ru.job4j.tracker;

/**
 * Класс Item для описания заявки.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Item {

    /**
     * Поле для уникального идентификатора.
     */
    private String id;

    /**
     * Поле для имени.
     */
    private String name;

    /**
     * Поле для даты создания.
     */
    private long create;

    /**
     * Поле для описания.
     */
    private String description;

    /**
     * Поле для комментариев.
     */
    private Comments comments;

    /**
     * Конструктор класса Item.
     * @param name имя заявки.
     * @param desc описание заявки.
     * @param create дата создания заявки.
     */
    public Item(String name, String desc, long create) {
        this.name = name;
        this.description = desc;
        this.create = create;
        this.comments = new Comments();
    }

    /**
     * Геттер для уникального идентификатора.
     * @return уникальный идентификатор.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Сеттер для уникального идентификатора.
     * @param id уникальный идентификатор.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Геттер для имени заявки.
     * @return имя заявки.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Геттер для даты создания заявки.
     * @return дата создания заявки.
     */
    public long getCreate() {
        return this.create;
    }

    /**
     * Геттер для описания заявки.
     * @return описание заявки.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Геттер для комментариев к заявке.
     * @return массив комментариев к заявке.
     */
    public String[] getComments() {
        return this.comments.getComments();
    }

    /**
     * Добавление комментария к заявке.
     * @param comment комментарий к заявке.
     */
    public void addComment(String comment) {
        this.comments.addComment(comment);
    }
}
