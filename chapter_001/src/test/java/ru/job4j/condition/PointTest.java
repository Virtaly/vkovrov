package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса Point.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class PointTest {

    /**
     * Тест для метода is.
     * Точка с координатами (2, 7) должна принадлежать графику y(x) = 2 * x + 3.
     */
    @Test
    public void whenPointOnLineThenTrue() {
        Point point = new Point(2, 7);
        boolean expected = true;
        boolean result = point.is(2, 3);
        assertThat(result, is(expected));
    }
}
