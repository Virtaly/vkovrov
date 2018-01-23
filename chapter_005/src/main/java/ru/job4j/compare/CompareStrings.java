package ru.job4j.compare;

import java.util.HashMap;
import java.util.Map;

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
        Map<Character, Integer> charMap = new HashMap<>();
        boolean charNotFound = false;
        for (int i = 0; i < s1.length(); i++) {
            int charCount = 1;
            if (charMap.containsKey(s1.charAt(i))) {
                charCount = charMap.get(s1.charAt(i)) + 1;
            }
            charMap.put(s1.charAt(i), charCount);
        }
        for (int i = 0; i < s2.length(); i++) {
            Integer charCount = charMap.get(s2.charAt(i));
            if (charCount == null) {
                charNotFound = true;
                break;
            }
            if (charCount > 1) {
                charCount--;
                charMap.put(s2.charAt(i), charCount);
            } else {
                charMap.remove(s2.charAt(i));
            }
        }
        return !charNotFound && charMap.isEmpty();
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
