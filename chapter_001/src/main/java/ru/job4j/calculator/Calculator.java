package ru.job4j.calculator;

/**
 * Class Calculator для вычисления арифметических операций.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Calculator {
    /**
     * Переменная result для хранения результата арифметической операции.
     */
    private double result;

    /**
     * Метод add для сложения двух чисел.
     * @param first первое слагаемое.
     * @param second второе слагаемое.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Метод subtract для вычитания одного числа из другого.
     * @param first уменьшаемое число.
     * @param second вычитаемое число.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Метод multiple для умножения двух чисел.
     * @param first первый множитель.
     * @param second второй множитель.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Метод div для деления одного числа на другое.
     * Выполняется проверка деления на ноль.
     * @param first делимое.
     * @param second делитель.
     */
    public void div(double first, double second) {
        this.result = second != 0 ? first / second : Double.NaN;
    }

    /**
     * Метод getResult возвращает результат арифметической операции.
     * @return результат арифметической операции.
     */
    public double getResult() {
        return this.result;
    }
}
