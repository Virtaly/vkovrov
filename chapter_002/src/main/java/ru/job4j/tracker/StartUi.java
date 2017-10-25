package ru.job4j.tracker;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.menu.MenuTracker;

/**
 * Класс StartUi для описания точки входа в систему.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class StartUi {

    /**
     * Поле для объекта, отвечающего за консольный ввод.
     */
    private Input input;

    /**
     * Поле для объекта, отвечающего за систему заявок.
     */
    private Tracker tracker;

    /**
     * Конструктор класса StartUi.
     * @param input обработчик пользовательского ввода.
     * @param tracker система заявок.
     */
    public StartUi(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для отображения пользовательского меню.
     */
    public void init() {
        MenuTracker menuTracker = new MenuTracker(this.tracker, this.input);
        menuTracker.createUserActionArr();
        int menuItem;
        do {
            System.out.println("\n########## Console Tracker made by vkovrov ##########\n");
            System.out.println("What do you want to do?");
            menuTracker.showMenu();
            menuItem = input.ask("Select:", new int[]{0, 1, 2, 3, 4, 5, 6});
            menuTracker.select(menuItem);
        } while (menuItem != 6);

    }

    /**
     * Метод точка входа в приложение.
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) {
        new StartUi(new ValidateInput(new StubInput(args)), new Tracker()).init();
    }
}
