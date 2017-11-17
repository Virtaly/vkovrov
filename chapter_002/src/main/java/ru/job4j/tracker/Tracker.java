package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс Tracker для описания трекера.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Tracker {

    /**
     * Поле для массива заявок.
     */
    private List<Item> items = new ArrayList<>();

    /**
     * Поле для генерации случайных чисел.
     */
    private static final Random RANDOM = new Random();

    /**
     * Метод для добавления новой заявки в массив.
     * @param item заявка.
     * @return та же заявка с уникальным идентификатором.
     */
    public Item addItem(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    /**
     * Метод для обновления заявки.
     * @param updateItem заявка, которую нужно обновить.
     */
    public void update(Item updateItem) {
        for (int i = 0; i < this.items.size(); i++) {
            if (items.get(i).getId().equals(updateItem.getId())) {
                items.set(i, updateItem);
                break;
            }
        }
    }

    /**
     * Метод для удаления заявки.
     * @param deleteItem заявка, которую нужно удалить.
     */
    public void delete(Item deleteItem) {
        for (int i = 0; i < this.items.size(); i++) {
            if (items.get(i).getId().equals(deleteItem.getId())) {
                items.remove(i);
            }
        }
    }

    /**
     * Геттер для массива заявок.
     * @return массив всех заявок.
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Метод для поиска заявок по имени.
     * @param name имя заявки.
     * @return массив найденных заявок.
     */
    public List<Item> findByName(String name) {
        List<Item> foundItems = new ArrayList<>();
        for (Item item : items) {
            if (name.equals(item.getName())) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    /**
     * Метод для поиска заявки по уникальному идентификатору.
     * @param id уникальный идентификатор.
     * @return найденная заявка или null.
     */
    public Item findById(String id) {
        Item foundItem = null;
        for (Item item : items) {
            if (id.equals(item.getId())) {
                foundItem = item;
                break;
            }
        }
        return foundItem;
    }

    /**
     * Метод для генерации случайного числа.
     * @return Строковое представление случайного числа.
     */
    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + RANDOM.nextInt());
    }
}
