package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса Calculator.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class CalculatorTest {

    /**
     * Тест для метода add.
     * Проверяется результат сложения двух числен 1d.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1d, 1d);
        double result = calc.getResult();
        double expected = 2d;
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода subtract.
     * Проверяется результат вычитания числа 1d из числа 1d.
     */
    @Test
    public void whenSubtractOneMinusOneThenZero() {
        Calculator calc = new Calculator();
        calc.subtract(1d, 1d);
        double result = calc.getResult();
        double expected = 0d;
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода multiple.
     * Проверяется результат умножения двух числен 2d.
     */
    @Test
    public void whenMultipleTwoAndTwoThenFour() {
        Calculator calc = new Calculator();
        calc.multiple(2d, 2d);
        double result = calc.getResult();
        double expected = 4d;
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода div.
     * Проверяется результат деления числа 5d на число 2d.
     */
    @Test
    public void whenDivFiveAndTwoThenTwoWithHalf() {
        Calculator calc = new Calculator();
        calc.div(5d, 2d);
        double result = calc.getResult();
        double expected = 2.5d;
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода div.
     * Проверяется результат деления числа 5d на число 0d.
     */
    @Test
    public void whenDivFiveAndZeroThenNaN() {
        Calculator calc = new Calculator();
        calc.div(5d, 0d);
        double result = calc.getResult();
        double expected = Double.NaN;
        assertThat(result, is(expected));
    }
}
