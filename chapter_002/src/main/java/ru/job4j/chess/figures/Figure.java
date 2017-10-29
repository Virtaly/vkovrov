package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 * Абстрактный класс для офисания шахматной фигуры.
 */
public abstract class Figure {

    /**
     * Поле для ячейки шахматной доски, на которой располагается фигура.
     */
    private final Cell position;

    /**
     * Конструктор класса.
     * @param position ячейка шахматной доски, на которой располагается фигура.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Метод для определия пути фигуры до ячейки назначения.
     * @param dist ячейка, в которую фигура должна прийти.
     * @return массив ячеек, которые фигура должна пройти, чтобы оказаться в ячейке назначения.
     * @throws ImpossibleMoveException исключение, если фигура не может пойти в ячейку назначения.
     */
    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * Метод для записи нового местоположения шахматной фигуры.
     * @param dist новоя ячейка, в которой будет располагаться фигура.
     * @return объект фигуры.
     */
    public abstract Figure clone(Cell dist);

    /**
     * Геттер для ячейки в которой располагается фигура.
     * @return ячейка в которой располагается фигура.
     */
    public Cell getPosition() {
        return this.position;
    }
}
