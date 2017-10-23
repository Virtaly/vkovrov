package ru.job4j.tracker;

/**
 * Класс StartUi для описания точки входа в систему.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class StartUi {
    /**
     * Константа для пункта меню добавить новую заявку.
     */
    private static final String ADD = "0";

    /**
     * Константа для пункта меню показать все заявки.
     */
    private static final String SHOW = "1";

    /**
     * Константа для пункта меню редактировать заявку.
     */
    private static final String EDIT = "2";

    /**
     * Константа для пункта меню удалить заявку.
     */
    private static final String DELETE = "3";

    /**
     * Константа для пункта меню найти заявку по идентификатору.
     */
    private static final String FINDID = "4";

    /**
     * Константа для пункта меню найти заявку по имени.
     */
    private static final String FINDNAME = "5";

    /**
     * Константа для пункта меню выход из программы.
     */
    private static final String EXIT = "6";

    /**
     * Константа для пункта подменю редактирования заявки -> редактировать имя заявки.
     */
    private static final String EDITNAME = "0";

    /**
     * Константа для пункта подменю редактирования заявки -> редактировать описание заявки.
     */
    private static final String EDITDESCRIPTION = "1";

    /**
     * Константа для пункта подменю редактирования заявки -> добавить комментарий к заявке.
     */
    private static final String ADDCOMMENT = "2";

    /**
     * Константа для пункта подменю редактирования заявки -> выйти из подменю.
     */
    private static final String EXITEDIT = "3";

    /**
     * Поле для объекта, отвечающего за консольный ввод.
     */
    private ConsoleInput consoleInput;

    /**
     * Поле для объекта, отвечающего за систему заявок.
     */
    private Tracker tracker;

    /**
     * Конструктор класса StartUi.
     * @param input обработчик пользовательского ввода.
     * @param tracker система заявок.
     */
    public StartUi(ConsoleInput input, Tracker tracker) {
        this.consoleInput = input;
        this.tracker = tracker;
    }

    /**
     * Метод для отображения пользовательского меню.
     */
    public void init() {
        String menuItem;
        do {
            System.out.println();
            System.out.println("######## Console Tracker made by vkovrov ########");
            System.out.println();
            System.out.println("0. Add new Item");
            System.out.println("1. Show all items");
            System.out.println("2. Edit item");
            System.out.println("3. Delete item");
            System.out.println("4. Find item by Id");
            System.out.println("5. Find items by name");
            System.out.println("6. Exit Program");
            System.out.println("Select: ");
            menuItem = this.consoleInput.ask();
        } while (!doTaskByMenuItem(menuItem).equals("-1"));
    }

    /**
     * Метод для выполнения определенного действия в зависимости от выбора пункта меню пользователем.
     * @param menuItem пункт меню, выбранный пользователем.
     * @return пункт меню, выбранный пользователем, или -1,
     * если пользовательский ввод не соответствует пункту меню.
     */
    public String doTaskByMenuItem(String menuItem) {
        switch (menuItem) {
            case ADD :
                this.addItem();
                break;
            case SHOW :
                this.findAll();
                break;
            case EDIT :
                this.update();
                break;
            case DELETE :
                this.delete();
                break;
            case FINDID :
                this.findById();
                break;
            case FINDNAME :
                this.findByName();
                break;
            case EXIT :
                menuItem = "-1";
                break;
            default :
                menuItem = "-1";
                break;
        }
        return menuItem;
    }

    /**
     * Метод для добавления новой заявки.
     */
    private void addItem() {
        System.out.println("Enter name of task:");
        String name = this.consoleInput.ask();
        System.out.println("Enter description:");
        String desc = this.consoleInput.ask();
        Item item = new Item(name, desc, System.currentTimeMillis());
        tracker.addItem(item);
        System.out.println("New item was added.");
    }

    /**
     * Метод для вывода на экран всех заявок, добавленных в систему.
     */
    private void findAll() {
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
    }

    /**
     * Метод для редактирования заявки.
     * Пользователю доступно подменю для редактирования заявки.
     */
    private void update() {
        System.out.println("Enter task id:");
        String id = this.consoleInput.ask();
        Item updateItem = tracker.findById(id);
        if (updateItem == null) {
            System.out.println("Task with id " + id + " not found.");
        } else {
            String editMenuItem = "-1";
            do {
                System.out.println("What do you what to edit in this item: ");
                System.out.println("0. Name");
                System.out.println("1. Description");
                System.out.println("2. Add comment");
                System.out.println("3. Exit submenu");
                System.out.println("Select: ");
                editMenuItem = this.consoleInput.ask();
            } while (!doTaskByEditMenuItem(editMenuItem, updateItem).equals("-1"));
        }
    }

    /**
     * Метод для выполнения определенного действия в зависимости от выбора пункта подменю,
     * расположенного в меню редактирования заявки, пользователем.
     * @param menuItem пункт подменю, выбранный пользователем.
     * @param item заявка, редактирование которой будет проводиться.
     * @return пункт подменю, выбранный пользователем.
     */
    public String doTaskByEditMenuItem(String menuItem, Item item) {
        switch (menuItem) {
            case EDITNAME :
                this.editName(item);
                break;
            case EDITDESCRIPTION :
                this.editDescription(item);
                break;
            case ADDCOMMENT :
                this.addComment(item);
                break;
            case EXITEDIT :
                menuItem = "-1";
                break;
            default :
                menuItem = "-1";
                break;
        }
        return menuItem;
    }

    /**
     * Метод для редактирования имени заявки.
     * @param updateItem заявка.
     */
    public void editName(Item updateItem) {
        System.out.println("Enter new task name:");
        String name = this.consoleInput.ask();
        Item itemWithNewName = new Item(name, updateItem.getDescription(), updateItem.getCreate());
        itemWithNewName.setId(updateItem.getId());
        this.tracker.update(itemWithNewName);
        System.out.println("The name of item with id " + updateItem.getId() + " was updated");
    }

    /**
     * Метод для редактирования описания заявки.
     * @param updateItem заявка.
     */
    public void editDescription(Item updateItem) {
        System.out.println("Enter new task description:");
        String description = this.consoleInput.ask();
        Item itemWithNewName = new Item(updateItem.getName(), description, updateItem.getCreate());
        itemWithNewName.setId(updateItem.getId());
        this.tracker.update(itemWithNewName);
        System.out.println("The description of item with id " + updateItem.getId() + " was updated");
    }

    /**
     * Метод для добавления комментария к заявке.
     * @param updateItem заявка.
     */
    public void addComment(Item updateItem) {
        System.out.println("Enter new comment:");
        updateItem.addComment(this.consoleInput.ask());
        this.tracker.update(updateItem);
        System.out.println("The new comment was added to the item with id " + updateItem.getId());
    }

    /**
     * Метод для удаления заявки.
     */
    private void delete() {
        System.out.println("Enter task id:");
        String id = this.consoleInput.ask();
        if (this.tracker.findById(id) != null) {
            this.tracker.delete(this.tracker.findById(id));
            System.out.println("Task №" + id + " was deleted.");
        } else {
            System.out.println("Task with id " + id + " not found.");
        }

    }

    /**
     * Метод для поиска заявки по уникальному идентификатору.
     */
    public void findById() {
        System.out.println("Enter task id:");
        String id = this.consoleInput.ask();
        if (this.tracker.findById(id) != null) {
            System.out.println("Task №" + id + " was found.");
        } else {
            System.out.println("Task with id " + id + " not found.");
        }
    }

    /**
     * Метод для поиска заявок по имени.
     * На экран будут выведены все заявки с именем, соответствующим запросу.
     */
    public void findByName() {
        System.out.println("Enter task name:");
        String name = this.consoleInput.ask();
        if (this.tracker.findByName(name) != null) {
            for (Item item : this.tracker.findByName(name)) {
                System.out.println(item);
            }
        } else {
            System.out.println("Tasks with name " + name + " not found.");
        }
    }

    /**
     * Метод точка входа в приложение.
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) {
        new StartUi(new ConsoleInput(), new Tracker()).init();
    }
}
