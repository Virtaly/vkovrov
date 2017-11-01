package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 * Класс для описания шахматной фигуры слон.
 */
public class Bishop extends Figure {

    /**
     * Конструктор класса.
     * @param position ячейка шахматной доски, на которой располагается фигура.
     */
    public Bishop(Cell position) {
        super(position);
    }

    /**
     * Метод для определия пути фигуры до ячейки назначения.
     * @param dist ячейка, в которую фигура должна прийти.
     * @return массив ячеек, которые фигура должна пройти, чтобы оказаться в ячейке назначения.
     * @throws ImpossibleMoveException исключение невозможности движения фигуры в указанную ячейку.
     */
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        int distanceX = this.getPosition().getX() - dist.getX();
        int distanceY = this.getPosition().getY() - dist.getY();
        Cell[] cellWay;
        if (Math.abs(distanceX) != Math.abs(distanceY)) {
            throw new ImpossibleMoveException();
        }
        cellWay = new Cell[Math.abs(distanceX)];
        int signX = distanceX / Math.abs(distanceX);
        int signY = distanceY / Math.abs(distanceY);
        for (int i = 1; i <= cellWay.length; i++) {
            cellWay[i - 1] = new Cell(this.getPosition().getX() + signX * i, this.getPosition().getY() + signY * i);
        }

        return cellWay;
    }

    /**
     * Метод для клонирования фигуры в ячейку назначения.
     * @param dist новоя ячейка, в которой будет располагаться фигура.
     * @return фигурв в новой ячейке.
     */
    public Figure clone(Cell dist) {
        return new Bishop(dist);
    }
}

