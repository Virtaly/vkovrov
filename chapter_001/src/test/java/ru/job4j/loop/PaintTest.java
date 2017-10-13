package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса Paint.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class PaintTest {

    /**
     * Тест для метода piramid.
     * должна создаться строка при выводе которой на экран получится пирамида высотой 3.
     */
    @Test
    public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
        Paint paint = new Paint();
        String expected = "  ^\n ^^^\n^^^^^\n";
        String result = paint.piramid(3);
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода piramid.
     * должна создаться строка при выводе которой на экран получится пирамида высотой 2.
     */
    @Test
    public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
        Paint paint = new Paint();
        String expected = " ^\n^^^\n";
        String result = paint.piramid(2);
        assertThat(result, is(expected));
    }
}
