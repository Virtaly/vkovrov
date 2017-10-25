package ru.job4j.tracker.menu;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * Класс для меню программы.
 */
public class MenuTracker {

    /**
     * Поле для массива действий пользователя.
     */
    private UserAction[] userActionArr;

    /**
     * Поле для системы заявок.
     */
    private Tracker tracker;

    /**
     * Поле для объекта взаимодействия с пользователем.
     */
    private Input input;

    /**
     * Конструктор класса.
     * @param tracker система заявок.
     * @param input объект для взаимодействия с пользователем.
     */
    public MenuTracker(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }

    /**
     * Метод для инициализации массива действий пользователя для главного меню.
     */
    public void createUserActionArr() {
        this.userActionArr = new UserAction[7];
        userActionArr[0] = new MenuTracker.AddItem();
        userActionArr[1] = this.new ShowAllItems();
        userActionArr[2] = new EditItemMenu(tracker, input);
        userActionArr[3] = this.new DeleteItem();
        userActionArr[4] = this.new FindById();
        userActionArr[5] = this.new FindByName();
        userActionArr[6] = new ExitProgram();
    }

    /**
     * Метод для вывода на экран пользовательского меню.
     */
    public void showMenu() {
        for (UserAction action : this.userActionArr) {
            System.out.println(action.getInfo());
        }
    }

    /**
     * Метод для запуска действия, выбранного пользователем.
     * @param key номер пункта меню.
     */
    public void select(int key) {
        userActionArr[key].execute(this.tracker, this.input);
    }

    /**
     * Метод для инициализации массива действий пользователя для подменю.
     * @param actions действия пользователя.
     */
    public void createUserActionArr(UserAction... actions) {
        this.userActionArr = new UserAction[actions.length];
        for (int i = 0; i < actions.length; i++) {
            userActionArr[i] = actions[i];
        }
    }

    /**
     * Класс для пункта меню Добавление новой заявки.
     */
    static class AddItem extends BaseAction {

        /**
         * Конструктор для класса добавления новой заявки.
         */
        AddItem() {
            super("0", "Add new item");
        }

        /**
         * Геттер для индекса действия в массиве действий.
         * @return индекс действия в массиве действий.
         */
        public String getKey() {
            return "0";
        }

        /**
         * Метод для добавления новой заявки.
         * @param tracker трекер задач.
         * @param input объект для взаимодействия с пользователем.
         */
        public void execute(Tracker tracker, Input input) {
            String name = input.ask("Enter name of task:");
            String desc = input.ask("Enter description:");
            Item item = new Item(name, desc, System.currentTimeMillis());
            tracker.addItem(item);
            System.out.println("New item was added.");
        }

    }

    /**
     * Класс для пункта меню Вывод на экран всех заявок, добавленных в систему.
     */
    class ShowAllItems extends BaseAction {

        /**
         * Конструктор для класса вывода на экран всех заявок, добавленных в систему.
         */
        ShowAllItems() {
            super("1", "Show all items");
        }

        /**
         * Геттер для индекса действия в массиве действий.
         * @return индекс действия в массиве действий.
         */
        public String getKey() {
            return "1";
        }

        /**
         * Метод для вывода на экран всех заявок, добавленных в систему.
         * @param tracker трекер задач.
         * @param input объект для взаимодействия с пользователем.
         */
        public void execute(Tracker tracker, Input input) {
            for (Item item : tracker.findAll()) {
                System.out.println(item);
            }
        }

    }

    /**
     * Класс для пункта меню Удаление заявки.
     */
    class DeleteItem extends BaseAction {

        /**
         * Конструктор для класса удаления заявки.
         */
        DeleteItem() {
            super("3", "Delete item");
        }

        /**
         * Геттер для индекса действия в массиве действий.
         * @return индекс действия в массиве действий.
         */
        public String getKey() {
            return "3";
        }

        /**
         * Метод для удаления заявки.
         * @param tracker трекер задач.
         * @param input объект для взаимодействия с пользователем.
         */
        public void execute(Tracker tracker, Input input) {
            String id = input.ask("Enter task id:");
            if (tracker.findById(id) != null) {
                tracker.delete(tracker.findById(id));
                System.out.println("Task №" + id + " was deleted.");
            } else {
                System.out.println("Task with id " + id + " not found.");
            }
        }

    }

    /**
     * Класс для пункта меню Поиск заявки по уникальному идентификатору.
     */
    class FindById extends BaseAction {

        /**
         * Конструктор для класса поиска заявки по уникальному идентификатору.
         */
        FindById() {
            super("4", "Find item by id");
        }

        /**
         * Геттер для индекса действия в массиве действий.
         * @return индекс действия в массиве действий.
         */
        public String getKey() {
            return "4";
        }

        /**
         * Метод для поиска заявки по уникальному идентификатору.
         * @param tracker трекер задач.
         * @param input объект для взаимодействия с пользователем.
         */
        public void execute(Tracker tracker, Input input) {
            String id = input.ask("Enter task id:");
            if (tracker.findById(id) != null) {
                System.out.println(tracker.findById(id).toString());
            } else {
                System.out.println("Task with id " + id + " not found.");
            }
        }
    }

    /**
     * Класс для пункта меню Поиск заявки по имени.
     */
    class FindByName extends BaseAction {

        /**
         * Конструктор для класса поиска заявок по имени.
         */
        FindByName() {
            super("5", "Find item by name");
        }

        /**
         * Геттер для индекса действия в массиве действий.
         * @return индекс действия в массиве действий.
         */
        public String getKey() {
            return "5";
        }

        /**
         * Метод для поиска заявок по имени.
         * На экран будут выведены все заявки с именем, соответствующим запросу.
         * @param tracker трекер задач.
         * @param input объект для взаимодействия с пользователем.
         */
        public void execute(Tracker tracker, Input input) {
            String name = input.ask("Enter task name:");
            if (tracker.findByName(name) != null) {
                for (Item item : tracker.findByName(name)) {
                    System.out.println(item);
                }
            } else {
                System.out.println("Tasks with name " + name + " not found.");
            }
        }
    }
}

/**
 * Класс для пункта меню Выход из программы.
 */
class ExitProgram extends BaseAction {

    /**
     * Конструктор для класса выхода из программы.
     */
    ExitProgram() {
        super("6", "Exit program");
    }

    /**
     * Геттер для индекса действия в массиве действий.
     * @return индекс действия в массиве действий.
     */
    public String getKey() {
        return "6";
    }

    /**
     * Метод для выхода из программы.
     * @param tracker трекер задач.
     * @param input объект для взаимодействия с пользователем.
     */
    public void execute(Tracker tracker, Input input) {

    }
}