package ru.job4j.max;

/**
 * Class Max для поиска маскимального из двух значений.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Max {

    /**
     * Метод max для поиска максимального из двух значений.
     * @param first первое значение.
     * @param second второе значение.
     * @return максимальное значение.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
