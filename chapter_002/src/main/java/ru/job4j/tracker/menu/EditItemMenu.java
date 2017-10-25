package ru.job4j.tracker.menu;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * Класс для пункта меню Изменение заявки.
 * Пользователю доступно подменю для редактирования заявки.
 */
public class EditItemMenu extends BaseAction {

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
        super("2", "Edit item");
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
            int editMenuItem;
            do {
                System.out.println("\nWhat do you what to edit in the item № " + id + "?");
                menuTracker.showMenu();
                editMenuItem = input.ask("Select: ", new int[]{0, 1, 2, 3});
                menuTracker.select(editMenuItem);
            } while (editMenuItem != 3);
        }
    }

    /**
     * Класс для пункта подменю Редактирование имени заявки.
     */
    class EditName extends BaseAction {

        /**
         * Конструктор для класса пункта подменю Редактирование имени заявки.
         */
        EditName() {
            super("0", "Name");
        }

        /**
         * Геттер для индекса действия в массиве действий.
         * @return индекс действия в массиве действий.
         */
        public String getKey() {
            return "0";
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
    class EditDescription extends BaseAction {

        /**
         * Конструктор для класса пункта подменю Редактирование описания заявки.
         */
        EditDescription() {
            super("1", "Description");
        }

        /**
         * Геттер для индекса действия в массиве действий.
         * @return индекс действия в массиве действий.
         */
        public String getKey() {
            return "1";
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
    class AddComment extends BaseAction {

        /**
         * Конструктор для класса пункта подменю Добавление комментария к заявке.
         */
        AddComment() {
            super("2", "Add comment");
        }

        /**
         * Геттер для индекса действия в массиве действий.
         * @return индекс действия в массиве действий.
         */
        public String getKey() {
            return "2";
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
    class ExitSubMenu extends BaseAction {

        /**
         * Конструктор для класса подпункта меню Выход из редактирования заявки.
         */
        ExitSubMenu() {
            super("3", "Exit submenu");
        }

        /**
         * Геттер для индекса действия в массиве действий.
         * @return индекс действия в массиве действий.
         */
        public String getKey() {
            return "3";
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
