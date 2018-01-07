package ru.job4j.threads;

import java.util.StringTokenizer;

/**
 * Класс для подсчета слов и пробелов в строке.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Counter {

    /**
     * Метод для параллельного подсчета пробелов и слов в строке.
     * @param s строка.
     */
    public void count(String s) {
        new Thread(() -> {
            int spaceCounter = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    spaceCounter++;
                }
            }
            System.out.println(spaceCounter);
        }).start();
        new Thread(() -> {
            int wordCounter = 0;
            StringTokenizer st = new StringTokenizer(s);
            while (st.hasMoreTokens()) {
                wordCounter++;
                st.nextToken();
            }
            System.out.println(wordCounter);
        }).start();
    }
}
