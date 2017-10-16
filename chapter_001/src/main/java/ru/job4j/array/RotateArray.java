package ru.job4j.array;

/**
 * Класс RotateArray для поворота квадратного массива.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class RotateArray {
    /**
     * Метод rotate поворачивает квадратный массив на 90 градусов.
     * @param array квадратный массив.
     * @return квадратный массив, повернутый на 90 градусов.
     */
    public int[][] rotate(int[][] array) {
        int[][] arr = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                arr[j][array.length - i - 1] = array[i][j];
            }
        }
        return arr;
    }

    /**
     * Метод rotateWithoutNewArray поворачивает квадратный массив на 90 градусов без создания нового массива.
     * @param arr квадратный массив.
     * @return квадратный массив, повернутый на 90 градусов.
     */
    public int[][] rotateWithoutNewArray(int[][] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = i; j < arr.length - i - 1; j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[arr.length - i - 1][j];
                arr[arr.length - i - 1][j] = arr[arr.length - j - 1][arr.length - i - 1];
                arr[arr.length - j - 1][arr.length - i - 1] = arr[i][arr.length - j - 1];
                arr[i][arr.length - j - 1] = temp;
            }
        }
        return arr;
    }
}
