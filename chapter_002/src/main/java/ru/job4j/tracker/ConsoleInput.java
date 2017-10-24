package ru.job4j.tracker;

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
}