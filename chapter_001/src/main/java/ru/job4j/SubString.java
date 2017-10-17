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
        char[] originArr = this.stringToCharArr(origin);
        char[] subArr = this.stringToCharArr(sub);
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

    /**
     * Метод stringToCharArr преобразует строку в массив символов.
     * @param string строка, которую нужно преобразовать.
     * @return массив символов из строки, переданной в параметре.
     */
    private char[] stringToCharArr(String string) {
        char[] charArr = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            charArr[i] = string.charAt(i);
        }
        return charArr;
    }

}
