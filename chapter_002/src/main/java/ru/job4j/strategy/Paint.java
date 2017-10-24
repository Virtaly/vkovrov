package ru.job4j.strategy;

/**
 * Класс Paint для прорисовки геометрических фигур.
 */
public class Paint {

    /**
     * Метод для прорисовки геометрических фигур.
     * @param draw геометрическая фигура.
     */
    public void draw(Shape draw) {
        System.out.print(draw.pic());
    }
}
