package ru.job4j.strategy;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
     * Тест для метода draw с прорисовкой треугольника.
     * Выведенная строка, изображающая треугольник, должна соответствовать ожидаемой.
     */
    @Test
    public void whenDrawTriangleThenWillBeExpectedString() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Paint paint = new Paint();
        paint.draw(new Triangle());
        String result = output.toString();
        String expected = "  *\n ***\n*****\n";
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода draw с прорисовкой квадрата.
     * Выведенная строка, изображающая квадрат, должна соответствовать ожидаемой.
     */
    @Test
    public void whenDrawSquareThenWillBeExpectedString() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Paint paint = new Paint();
        paint.draw(new Square());
        String result = output.toString();
        String expected = "***\n***\n***\n";
        assertThat(result, is(expected));
    }


}