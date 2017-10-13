package ru.job4j.condition;

/**
 * Class Point для описания положения точки на плоскости.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Point {
    /**
     * координата точки по оси абсцисс.
     */
    private int x;
    /**
     * координата точки по оси ординат.
     */
    private int y;

    /**
     * Конструктор класса Point.
     * @param x координата по оси абсцисс.
     * @param y координата по оси ординат.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод определяющий находится ли точка на графике линейной фукнции y(x) = a * x + b.
     * @param a коэффициент наклона графика.
     * @param b коэффициент сдвига графика вдоль оси ординат.
     * @return принадлежит ли точка графику функции с заданными параметрами.
     */
    public boolean is(int a, int b) {
        return this.y == a * this.x + b ? true : false;
    }

    /**
     * Метод для возвращения координаты по оси абсцисс.
     * @return координата по оси абсцисс.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Метод для возвращения координаты по оси ординат.
     * @return координата по оси ординат.
     */
    public int getY() {
        return this.y;
    }

}
