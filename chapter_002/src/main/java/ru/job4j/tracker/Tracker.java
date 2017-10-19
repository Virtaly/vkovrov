package ru.job4j.tracker;

import java.util.Arrays;
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
    private Item[] items = new Item[100];

    /**
     * Поле для позиции, в которую будет записываться следующая заявка.
     */
    private int position = 0;

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
        items[this.position++] = item;
        return item;
    }

    /**
     * Метод для обновления заявки.
     * @param updateItem заявка, которую нужно обновить.
     */
    public void update(Item updateItem) {
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(updateItem.getId())) {
                items[i] = updateItem;
                break;
            }
        }
    }

    /**
     * Метод для удаления заявки.
     * @param deleteItem заявка, которую нужно удалить.
     */
    public void delete(Item deleteItem) {
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(deleteItem.getId())) {
                for (int j = i; j < this.position - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[--this.position] = null;
            }
        }
    }

    /**
     * Геттер для массива заявок.
     * @return массив всех заявок.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Метод для поиска заявок по имени.
     * @param name имя заявки.
     * @return массив найденных заявок.
     */
    public Item[] findByName(String name) {
        Item[] foundItems = new Item[this.position];
        int foundItemsPosition = 0;
        for (int i = 0; i < this.position; i++) {
            if (name.equals(items[i].getName())) {
                foundItems[foundItemsPosition++] = items[i];
            }
        }
        return Arrays.copyOf(foundItems, foundItemsPosition);
    }

    /**
     * Метод для поиска заявки по уникальному идентификатору.
     * @param id уникальный идентификатор.
     * @return найденная заявка или null.
     */
    public Item findById(String id) {
        Item foundItem = null;
        for (int i = 0; i < this.position; i++) {
            if (id.equals(items[i].getId())) {
                foundItem = items[i];
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

    /**
     * Геттер для позиции следующей записываемой заявки.
     * @return позиция следующей записываемой заявки.
     */
    public int getPosition() {
        return this.position;
    }
}
