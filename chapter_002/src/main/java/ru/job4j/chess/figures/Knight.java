package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 * Класс для описания шахматной фигуры конь.
 */
public class Knight extends Figure {

    /**
     * Конструктор класса.
     * @param position ячейка шахматной доски, на которой располагается фигура.
     */
    public Knight(Cell position) {
        super(position);
    }

    /**
     * Метод для определия пути фигуры до ячейки назначения.
     * @param dist ячейка, в которую фигура должна прийти.
     * @return массив ячеек, которые фигура должна пройти, чтобы оказаться в ячейке назначения.
     * @throws ImpossibleMoveException исключение, если фигура не может пойти в ячейку назначения.
     */
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        return null;
    }

    /**
     * Метод для клонирования фигуры в ячейку назначения.
     * @param dist новоя ячейка, в которой будет располагаться фигура.
     * @return фигурв в новой ячейке.
     */
    public Figure clone(Cell dist) {
        return new Knight(dist);
    }
}
