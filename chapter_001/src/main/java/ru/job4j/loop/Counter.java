package ru.job4j.loop;

/**
 * Class Counter для вычисления суммы чисел.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Counter {

    /**
     * Метод add для вычисления суммы четных чисел в указанном диапазоне.
     * @param start начало диапазона.
     * @param finish конец диапазона.
     * @return сумма четных чисел.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
