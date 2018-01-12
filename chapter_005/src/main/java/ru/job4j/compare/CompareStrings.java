package ru.job4j.compare;

import java.util.TreeSet;

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
     * Метод для определения состоят ли строки из одинаковых букв, стабильный.
     * @param s1 первая строка.
     * @param s2 вторая строка.
     * @return true, если строки состоят из одинаковых букв.
     */
    public boolean compareStable(String s1, String s2) {
        TreeSet<Character> charTreeFirst = new TreeSet<>();
        TreeSet<Character> charTreeSecond = new TreeSet<>();
        for (int i = 0; i < s1.length(); i++) {
            charTreeFirst.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            charTreeSecond.add(s2.charAt(i));
        }
        return charTreeFirst.size() == charTreeSecond.size() && charTreeFirst.containsAll(charTreeSecond);
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
