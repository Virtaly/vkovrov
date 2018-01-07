package ru.job4j.threads;

/**
 * Класс для подсчета символов в строке.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class CountChar implements Runnable {

    /**
     * Поле для хранения строки.
     */
    private String text;

    /**
     * Поле для хранения количества символов в тексте.
     */
    private int counter = 0;

    /**
     * Конструктор класса.
     * @param text текст для подсчета символов.
     */
    public CountChar(String text) {
        this.text = text;
    }

    /**
     * Метод для подсчета количества символов в тексте.
     */
    @Override
    public void run() {
        for (int i = 0; i < text.length(); i++) {
            if (!Thread.interrupted()) {
                char ch = text.charAt(i);
                if (ch != ' ' && ch != ',' && ch != '.') {
                    counter++;
                }
            } else {
                System.out.println("Поток был прерван");
                return;
            }
        }
        System.out.println("В строке символов: " + counter);

    }
}
