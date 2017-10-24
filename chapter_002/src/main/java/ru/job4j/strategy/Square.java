package ru.job4j.strategy;

/**
 * Класс Square для геометрической фигуры квадрат.
 */
public class Square implements Shape {

    /**
     * Метод для создания строки, при выводе которой на экран получится квадрат.
     * @return строка, при выводе которой на экран получится квадрат.
     */
    public String pic() {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sBuilder.append("*");
            }
            sBuilder.append("\n");
        }
        return sBuilder.toString();
    }
}
