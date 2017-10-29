package ru.job4j.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования движения шахматных фигур.
 */
public class ChessTest {

    /**
     * Тест для движения шахматных фигур.
     */
    @Test
    public void whenMoveBishopThenTrueButOnlyAfterMovingPawn() {
        Board chessBoard = new Board();
        chessBoard.initBoard();
        chessBoard.move(new Cell(1, 1), new Cell(2, 1));
        chessBoard.move(new Cell(0, 2), new Cell(2, 0));
        boolean result = chessBoard.move(new Cell(2, 0), new Cell(5, 3));
        boolean expected = true;
        assertThat(result, is(expected));
    }
}
