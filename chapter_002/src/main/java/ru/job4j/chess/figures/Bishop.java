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
        Cell[] cellWay;
        if (((this.getPosition().getX() - this.getPosition().getY()) != (dist.getX() - dist.getY()))
                && ((this.getPosition().getX() + this.getPosition().getY()) != (dist.getX() + dist.getY()))) {
            throw new ImpossibleMoveException();
        }
        cellWay = new Cell[Math.abs(this.getPosition().getX() - dist.getX())];
        if (dist.getX() > this.getPosition().getX()) {
            if (dist.getY() > this.getPosition().getY()) {
                for (int i = 1; i <= cellWay.length; i++) {
                    cellWay[i - 1] = new Cell(this.getPosition().getX() + i, this.getPosition().getY() + i);
                }
            } else {
                for (int i = 1; i <= cellWay.length; i++) {
                    cellWay[i - 1] = new Cell(this.getPosition().getX() + i, this.getPosition().getY() - i);
                }
            }
        } else {
            if (dist.getY() > this.getPosition().getY()) {
                for (int i = 1; i <= cellWay.length; i++) {
                    cellWay[i - 1] = new Cell(this.getPosition().getX() - i, this.getPosition().getY() + i);
                }
            } else {
                for (int i = 1; i <= cellWay.length; i++) {
                    cellWay[i - 1] = new Cell(this.getPosition().getX() - i, this.getPosition().getY() - i);
                }
            }
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

