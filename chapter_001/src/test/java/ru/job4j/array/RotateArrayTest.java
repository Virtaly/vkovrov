package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса RotateArray.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class RotateArrayTest {

    /**
     * Тест для метода rotate.
     * Метод принимает квадратный массив 2x2 и должен вернуть его повернутым на 90 градусов.
     */
    @Test
    public void whenSquareTwoByTwoThenRotateNinetyDegrees() {
        RotateArray rotateArray = new RotateArray();
        int[][] result = rotateArray.rotate(new int[][]{{1, 2}, {3, 4}});
        int[][] expected = {{3, 1}, {4, 2}};
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода rotate.
     * Метод принимает квадратный массив 3x3 и должен вернуть его повернутым на 90 градусов.
     */
    @Test
    public void whenSquareThreeByThreeThenRotateNinetyDegrees() {
        RotateArray rotateArray = new RotateArray();
        int[][] result = rotateArray.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода rotate.
     * Метод принимает квадратный массив 4x4 и должен вернуть его повернутым на 90 градусов.
     */
    @Test
    public void whenSquareFourByFourThenRotateNinetyDegrees() {
        RotateArray rotateArray = new RotateArray();
        int[][] result = rotateArray.rotate(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        int[][] expected = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода rotate.
     * Метод принимает квадратный массив 5x5 и должен вернуть его повернутым на 90 градусов.
     */
    @Test
    public void whenSquareFiveByFiveThenRotateNinetyDegrees() {
        RotateArray rotateArray = new RotateArray();
        int[][] result = rotateArray.rotate(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}});
        int[][] expected = {{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2}, {23, 18, 13, 8, 3}, {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}};
        assertThat(result, is(expected));
    }

// -------------Тесты для метода rotateWithoutNewArray-------------

    /**
     * Тест для метода rotateWithoutNewArray.
     * Метод принимает квадратный массив 2x2 и должен вернуть его повернутым на 90 градусов.
     */
    @Test
    public void whenSquareTwoByTwoThenRotateWithoutNewArrayNinetyDegrees() {
        RotateArray rotateArray = new RotateArray();
        int[][] result = rotateArray.rotateWithoutNewArray(new int[][]{{1, 2}, {3, 4}});
        int[][] expected = {{3, 1}, {4, 2}};
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода rotateWithoutNewArray.
     * Метод принимает квадратный массив 3x3 и должен вернуть его повернутым на 90 градусов.
     */
    @Test
    public void whenSquareThreeByThreeThenRotateWithoutNewArrayNinetyDegrees() {
        RotateArray rotateArray = new RotateArray();
        int[][] result = rotateArray.rotateWithoutNewArray(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода rotateWithoutNewArray.
     * Метод принимает квадратный массив 4x4 и должен вернуть его повернутым на 90 градусов.
     */
    @Test
    public void whenSquareFourByFourThenRotateWithoutNewArrayNinetyDegrees() {
        RotateArray rotateArray = new RotateArray();
        int[][] result = rotateArray.rotateWithoutNewArray(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        int[][] expected = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода rotateWithoutNewArray.
     * Метод принимает квадратный массив 5x5 и должен вернуть его повернутым на 90 градусов.
     */
    @Test
    public void whenSquareFiveByFiveThenRotateWithoutNewArrayNinetyDegrees() {
        RotateArray rotateArray = new RotateArray();
        int[][] result = rotateArray.rotateWithoutNewArray(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}});
        int[][] expected = {{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2}, {23, 18, 13, 8, 3}, {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}};
        assertThat(result, is(expected));
    }


}