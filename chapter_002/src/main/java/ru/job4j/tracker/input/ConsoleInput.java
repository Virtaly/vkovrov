package ru.job4j.tracker.input;

import ru.job4j.tracker.menu.MenuOutException;
import java.util.Scanner;

/**
 * Класс ConsoleInput для ввода пользовательских данных из консоли.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class ConsoleInput implements Input {
    /**
     * Поле для объекта, отвечающего за считывание пользовательского ввода.
     */
   private Scanner scanner = new Scanner(System.in);

    /**
     * Метод для считывания пользовательского ввода.
     * @param question вопрос пользователю.
     * @return строка, в которой содержится пользовательский ввод.
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * Метод для взаимодействия с пользователем,
     * для версии с защитой от некорректного ввода.
     * @param question вопрос пользователю.
     * @param range диапазон значений меню.
     * @return ответ пользователя.
     */
    public int ask(String question, int[] range) {
        System.out.println(question);
        boolean validMenuItemNumber = false;
        int menuItem;
        menuItem = Integer.valueOf(scanner.nextLine());
        for (int menuItemNumber : range) {
            if (menuItemNumber == menuItem) {
                validMenuItemNumber = true;
                break;
            }
        }
        if (!validMenuItemNumber) {
            throw new MenuOutException("Out of menu range!");
        }
        return menuItem;
    }
}