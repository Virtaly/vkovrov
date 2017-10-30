package ru.job4j.automatic;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса AutomaticMachine.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class AutomaticMachineTest {

    /**
     * Тест для метода getCoins.
     * Метод должен вернуть массив, содержащий правильное количество монет для каждого номинала для сдачи.
     */
    @Test
    public void whenPriceEightAndCashHundredThenCoinsLikeExpected() {
        AutomaticMachine automatic = new AutomaticMachine();
        int[] expected = new int[]{9, 0, 1, 0};
        int[] result = automatic.getCoins(100, 8);
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода getCoins.
     * Метод должен вернуть массив, содержащий правильное количество монет для каждого номинала для сдачи.
     */
    @Test
    public void whenPriceTwentyThreeAndCashHundredThenCoinsLikeExpected() {
        AutomaticMachine automatic = new AutomaticMachine();
        int[] expected = new int[]{7, 1, 1, 0};
        int[] result = automatic.getCoins(100, 23);
        assertThat(result, is(expected));
    }

}