package ru.job4j.strategy;

/**
 * Класс Triangle для геометрической фигуры треугольник.
 */
public class Triangle implements Shape {
    /**
     * Метод для создания строки, при выводе которой на экран получится треугольник.
     * @return строка, при выводе которой на экран получится треугольник.
     */
    public String pic() {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 - i - 1; j++) {
                sBuilder.append(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                sBuilder.append("*");
            }
            sBuilder.append("\n");
        }
        return sBuilder.toString();
    }
}
