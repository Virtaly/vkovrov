package ru.job4j.tracker.input;

import ru.job4j.tracker.menu.MenuOutException;

/**
 * Класс ValidateInput для валидации ввода пользовательских данных из консоли.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class ValidateInput implements Input {

    /**
     * Поле для объекта пользовательского ввода.
     */
    private Input input;

    /**
     * Конструктор класса.
     * @param input объекта пользовательского ввода.
     */
    public ValidateInput(Input input) {
        this.input = input;
    }

    /**
     * Метод для обработки ошибок пользовательского ввода при выборе пункта меню.
     * @param question вопрос пользователю.
     * @param range диапазон значений меню.
     * @return ответ пользователя.
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int menuItem = -1;
        do {
            try {
                menuItem = input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please enter menu item's number!");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valid data (number of menu item)!");
            }
        } while (invalid);


        return menuItem;
    }

    /**
     * Метод для считывания пользовательского ввода.
     * @param question вопрос пользователю.
     * @return строка, в которой содержится пользовательский ввод.
     */
    public String ask(String question) {
        return input.ask(question);
    }
}
