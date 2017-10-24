package ru.job4j.tracker.menu;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

/**
 * Класс для пункта меню Изменение заявки.
 * Пользователю доступно подменю для редактирования заявки.
 */
public class EditItemMenu implements UserAction {

    /**
     * Поле для структуры подменю Редактирование заявки.
     */
    private MenuTracker menuTracker;

    /**
     * Поле для заявки, которая будет обновляться.
     */
    private Item updateItem;

    /**
     * Конструктор для подменю Редактирование заявки.
     * @param tracker трекер задач.
     * @param input объект для взаимодействия с пользователем.
     */
    public EditItemMenu(Tracker tracker, Input input) {
        this.menuTracker = new MenuTracker(tracker, input);
    }
    /**
     * Геттер для индекса действия в массиве действий.
     * @return индекс действия в массиве действий.
     */
    public String getKey() {
        return "2";
    }

    /**
     * Геттер для информации о действии пользователя.
     * @return информация о действии пользователя.
     */
    public String getInfo() {
        return String.format("%s. %s", this.getKey(), "Edit item");
    }

    /**
     * Метод для редактирования заявки.
     * Пользователю доступно подменю для редактирования заявки.
     * @param tracker трекер задач.
     * @param input объект для взаимодействия с пользователем.
     */
    public void execute(Tracker tracker, Input input) {
        menuTracker.createUserActionArr(new EditName(), new EditDescription(), new AddComment(), new ExitSubMenu());
        String id = input.ask("Enter task id:");
        updateItem = tracker.findById(id);
        if (updateItem == null) {
            System.out.println("Task with id " + id + " not found.");
        } else {
            String editMenuItem = "-1";
            do {
                System.out.println("\nWhat do you what to edit in the item № " + id + "?");
                menuTracker.showMenu();
                editMenuItem = input.ask("Select: ");
            } while (menuTracker.select(editMenuItem));
        }
    }

    /**
     * Класс для пункта подменю Редактирование имени заявки.
     */
    class EditName implements UserAction {
        /**
         * Геттер для индекса действия в массиве действий.
         * @return индекс действия в массиве действий.
         */
        public String getKey() {
            return "0";
        }

        /**
         * Геттер для информации о действии пользователя.
         * @return информация о действии пользователя.
         */
        public String getInfo() {
            return String.format("%s. %s", this.getKey(), "Name");
        }

        /**
         * Метод для редактирования имени заявки.
         * @param tracker трекер задач.
         * @param input объект для взаимодействия с пользователем.
         */
        public void execute(Tracker tracker, Input input) {
            String name = input.ask("Enter new task name:");
            Item itemWithNewName = new Item(name, updateItem.getDescription(), updateItem.getCreate());
            itemWithNewName.setId(updateItem.getId());
            tracker.update(itemWithNewName);
            System.out.println("The name of item with id " + updateItem.getId() + " was updated");
        }

    }

    /**
     * Класс для пункта подменю Редактирование описания заявки.
     */
    class EditDescription implements UserAction {
        /**
         * Геттер для индекса действия в массиве действий.
         * @return индекс действия в массиве действий.
         */
        public String getKey() {
            return "1";
        }

        /**
         * Геттер для информации о действии пользователя.
         * @return информация о действии пользователя.
         */
        public String getInfo() {
            return String.format("%s. %s", this.getKey(), "Description");
        }

        /**
         * Метод для редактирования описания заявки.
         * @param tracker трекер задач.
         * @param input объект для взаимодействия с пользователем.
         */
        public void execute(Tracker tracker, Input input) {
            String description = input.ask("Enter new task description:");
            Item itemWithNewName = new Item(updateItem.getName(), description, updateItem.getCreate());
            itemWithNewName.setId(updateItem.getId());
            tracker.update(itemWithNewName);
            System.out.println("The description of item with id " + updateItem.getId() + " was updated");
        }

    }

    /**
     * Класс для пункта подменю Добавление комментария к заявке.
     */
    class AddComment implements UserAction {
        /**
         * Геттер для индекса действия в массиве действий.
         * @return индекс действия в массиве действий.
         */
        public String getKey() {
            return "2";
        }

        /**
         * Геттер для информации о действии пользователя.
         * @return информация о действии пользователя.
         */
        public String getInfo() {
            return String.format("%s. %s", this.getKey(), "Add comment");
        }

        /**
         * Метод для добавления комментария к заявке.
         * @param tracker трекер задач.
         * @param input объект для взаимодействия с пользователем.
         */
        public void execute(Tracker tracker, Input input) {
            updateItem.addComment(input.ask("Enter new comment:"));
            tracker.update(updateItem);
            System.out.println("The new comment was added to the item with id " + updateItem.getId());
        }

    }

    /**
     * Класс для подпункта меню Выход из редактирования заявки.
     */
    class ExitSubMenu implements UserAction {

        /**
         * Геттер для индекса действия в массиве действий.
         * @return индекс действия в массиве действий.
         */
        public String getKey() {
            return "3";
        }

        /**
         * Геттер для информации о действии пользователя.
         * @return информация о действии пользователя.
         */
        public String getInfo() {
            return String.format("%s. %s", this.getKey(), "Exit submenu");
        }

        /**
         * Метод для выхода из программы.
         * @param tracker трекер задач.
         * @param input объект для взаимодействия с пользователем.
         */
        public void execute(Tracker tracker, Input input) {

        }
    }
}
