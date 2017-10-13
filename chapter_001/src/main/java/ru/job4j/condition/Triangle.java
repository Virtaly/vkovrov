package ru.job4j.condition;

/**
 * Class Triangle для описания положения треугольника на плоскости.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Triangle {

    /**
     * Первая вершина треугольника.
     */
    private Point a;

    /**
     * Вторая вершина треугольника.
     */
    private Point b;

    /**
     * Третья вершина треугольника.
     */
    private Point c;

    /**
     * Конструктор класса Triangle.
     * @param a первая вершина треугольника.
     * @param b вторая вершина треугольника.
     * @param c третья вершина треугольника.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     * @param ab расстояние от точки a до точки b.
     * @param bc расстояние от точки b до точки c.
     * @param ac расстояние от точки a до точки c.
     * @return true если можно построить треугольник и false если нельзя.
     */
    public boolean exist(double ab, double bc, double ac) {
        return (ab > 0) && (ac > 0) && (bc > 0) && (ab + bc > ac) && (ab + ac > bc) && (ac + bc > ab);
    }

    /**
     * Метод вычисляет расстояние между двумя точками.
     * @param a точка a.
     * @param b точка b.
     * @return расстояние между двумя точками.
     */
    public double distance(Point a, Point b) {
        return Math.sqrt(Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2));
    }

    /**
     * Метод вычисляет периметр треугольника.
     * @param ab длина первой стороны треугольника.
     * @param bc длина второй стороны треугольника.
     * @param ac длина третьей стороны треугольника.
     * @return периметр треугольника.
     */
    public double period(double ab, double bc, double ac) {
        return (ab + bc + ac) / 2;
    }

    /**
     * Метод вычисляет площадь треугольника.
     * @return площадь треугольника, если он существует, иначе -1.
     */
    public double area() {
        double result = -1;
        double ab = this.distance(this.a, this.b);
        double bc = this.distance(this.b, this.c);
        double ac = this.distance(this.a, this.c);
        if (this.exist(ab, bc, ac)) {
            double p = this.period(ab, bc, ac);
            result = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
        }
        return result;
    }

}
