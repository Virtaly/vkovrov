package ru.job4j.loop;

/**
 * Class Factorial для вычисления факториала.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Factorial {

    /**
     * Метод calc используется для вычисления факториала.
     * @param number число для которого нужно посчитать факториал.
     * @return факториал числа.
     */
    public int calc(int number) {
        int fact = 1;
        for (int i = number; i > 0; i--) {
            fact *= i;
        }
        return fact;
    }
}
