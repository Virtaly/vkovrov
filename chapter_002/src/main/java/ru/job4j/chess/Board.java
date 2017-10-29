package ru.job4j.chess;

import ru.job4j.chess.figures.Bishop;
import ru.job4j.chess.figures.King;
import ru.job4j.chess.figures.Knight;
import ru.job4j.chess.figures.Pawn;
import ru.job4j.chess.figures.Queen;
import ru.job4j.chess.figures.Rook;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;

/**
 * Класс для описания шахматной доски.
 */
public class Board {

    /**
     * Поле для массива фигур, участвующих в шахматном сражении.
     */
    private Figure[] figures;

    /**
     * Конструктор класса.
     */
    public Board() {
        this.figures = new Figure[32];
    }

    /**
     * Метод для расстановки шахматных фигур на доске.
     */
    public void initBoard() {
        for (int i = 0; i <= 7; i++) {
            if (i == 0 || i == 7) {
                this.figures[i] = new Rook(new Cell(0, i));
                this.figures[i + 16] = new Rook(new Cell(7, i));
            } else if (i == 1 || i == 6) {
                this.figures[i] = new Knight(new Cell(0, i));
                this.figures[i + 16] = new Knight(new Cell(7, i));
            } else if (i == 2 || i == 5) {
                this.figures[i] = new Bishop(new Cell(0, i));
                this.figures[i + 16] = new Bishop(new Cell(7, i));
            } else if (i == 3) {
                this.figures[i] = new King(new Cell(0, i));
                this.figures[i + 16] = new King(new Cell(7, i));
            } else {
                this.figures[i] = new Queen(new Cell(0, i));
                this.figures[i + 16] = new Queen(new Cell(7, i));
            }
            this.figures[i + 8] = new Pawn(new Cell(1, i));
            this.figures[i + 24] = new Pawn(new Cell(6, i));
        }
    }

    /**
     * Метод для движения фигуры из исходной ячейки в ячейку назначения.
     * @param source исходная ячейка.
     * @param dist ячейка назначения.
     * @return возможно ли пройти фигуре по указанному пути.
     * @throws ImpossibleMoveException исключение невозможности движения фигуры в указанную ячейку.
     * @throws OccupiedWayException исключение занятого пути другой фигурой.
     * @throws FigureNotFoundException исключение невозможности найти фигуру.
     */
    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Figure figure = null;
        int index = -1;
        for (int i = 0; i < figures.length; i++) {
            if (source.getX() == figures[i].getPosition().getX() && source.getY() == figures[i].getPosition().getY()) {
                figure = figures[i];
                index = i;
            }
        }
        if (figure != null) {
            Cell[] cellWay = figure.way(dist);
            this.isOccupiedWay(cellWay);
            figures[index] = figure.clone(dist);

        } else {
            throw new FigureNotFoundException();
        }
        return true;
    }

    /**
     * Метод для определения отсутствия на пути другой фигуры.
     * @param cellWay массив ячеек, которые фигура должна пройти, чтобы оказаться в ячейке назначения.
     * @throws OccupiedWayException исключение занятого пути другой фигурой.
     */
    public void isOccupiedWay(Cell[] cellWay) throws OccupiedWayException {
        boolean isOccupied = true;
        for (Cell cell : cellWay) {
            for (Figure figure : this.figures) {
                if (cell.getX() == figure.getPosition().getX() && cell.getY() == figure.getPosition().getY()) {
                    isOccupied = false;
                }
            }
        }
        if (!isOccupied) {
            throw new OccupiedWayException();
        }
    }
}
