package ru.job4j.condition;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Тест для класса Triangle.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class TriangleTest {

    /**
     * Тест для метода area.
     */
    @Test
    public void whenRightTriangleWithCathetersLengthFourThenAreaEight() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(0, 4), new Point(4, 0));
        double expected = 8d;
        double result = triangle.area();
        assertThat(result, closeTo(expected, 0.1));
    }
}
