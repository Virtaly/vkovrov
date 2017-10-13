package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса Board.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class BoardTest {

    /**
     * Тест для метода paint.
     * должна создаться строка при выводе которой на экран получится шахматная доска 3х3.
     */
    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String expected = "X X\n X \nX X\n";
        String result = board.paint(3, 3);
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода paint.
     * должна создаться строка при выводе которой на экран получится шахматная доска 5х4.
     */
    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String expected = "X X X\n X X \nX X X\n X X \n";
        String result = board.paint(5, 4);
        assertThat(result, is(expected));
    }
}
