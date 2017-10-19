package ru.job4j;

/**
 * Класс SubString для переворачивания массива.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class SubString {

    /**
     * Метод contains проверяет наличие подстроки в строке.
     * @param origin строка, которую нужно проверить на содержание подстроки.
     * @param sub подстрока.
     * @return true - если подстрока найдена, иначе false.
     */
    public boolean contains(String origin, String sub) {
        char[] originArr = origin.toCharArray();
        char[] subArr = sub.toCharArray();
        boolean isSub = false;
        int i = 0;
        while (!isSub && i < originArr.length - subArr.length) {
            if (originArr[i] == subArr[0]) {
                int sameChars = 1;
                int j = 1;
                while (!isSub && j < subArr.length) {
                    if (originArr[i + j] == subArr[j]) {
                        sameChars++;
                    }
                    if (sameChars == subArr.length) {
                        isSub = true;
                    }
                    j++;
                }
            }
            i++;
        }
        return isSub;
    }
}
