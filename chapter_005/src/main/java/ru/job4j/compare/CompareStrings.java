package ru.job4j.compare;

/**
 * Класс для определения состоят ли строки из одинаковых букв.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class CompareStrings {

    /**
     * Метод для определения состоят ли строки из одинаковых букв.
     * @param s1 первая строка.
     * @param s2 вторая строка.
     * @return true, если строки состоят из одинаковых букв.
     */
    public boolean compare(String s1, String s2) {
        return this.getHash(s1) == this.getHash(s2);
    }

    /**
     * Метод для вычисления хеш-кода для строки.
     * @param s строка.
     * @return хеш-код.
     */
    public int getHash(String s) {
        char[] charArr = s.toCharArray();
        int hash = 0;
        for (int i = 0; i < charArr.length; i++) {
            hash += charArr[i];
        }
        return hash * 31;
    }
}
