package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 * Класс для описания шахматной фигуры пешка.
 */
public class Pawn extends Figure {

    /**
     * Конструктор класса.
     * @param position ячейка шахматной доски, на которой располагается фигура.
     */
    public Pawn(Cell position) {
        super(position);
    }

    /**
     * Метод для определия пути фигуры до ячейки назначения.
     * @param dist ячейка, в которую фигура должна прийти.
     * @return массив ячеек, которые фигура должна пройти, чтобы оказаться в ячейке назначения.
     * @throws ImpossibleMoveException исключение, если фигура не может пойти в ячейку назначения.
     */
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        Cell[] cellWay;
        if ((this.getPosition().getY() != dist.getY()) || (dist.getX() < this.getPosition().getX()
                || dist.getX() - this.getPosition().getX() > 1)) {
            throw new ImpossibleMoveException();
        }
        cellWay = new Cell[Math.abs(this.getPosition().getX() - dist.getX())];
        for (int i = 1; i <= cellWay.length; i++) {
            cellWay[i - 1] = new Cell(this.getPosition().getX() + i, this.getPosition().getY());
        }
        return cellWay;
    }

    /**
     * Метод для клонирования фигуры в ячейку назначения.
     * @param dist новоя ячейка, в которой будет располагаться фигура.
     * @return фигурв в новой ячейке.
     */
    public Figure clone(Cell dist) {
        return new Pawn(dist);
    }
}
