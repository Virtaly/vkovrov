package ru.job4j.bomberman;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс для игрового поля.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class GameField {

    /**
     * Поле для двумерного массива замков.
     */
    private final ReentrantLock[][] board;

    /**
     * Конструктор класса.
     * @param height высота поля.
     * @param width ширина поля.
     */
    public GameField(int height, int width) {
        board = new ReentrantLock[height][width];
        this.boardInitiate();
    }

    /**
     * Метод для создания игрового поля.
     */
    private synchronized void boardInitiate() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
    }

    /**
     * Метод для захвата ячейки игрового поля.
     * @param x координата ячейки по оси абсцисс.
     * @param y координата ячейки по оси ординат.
     * @return true, если получилось занять ячейку.
     */
    public boolean lockCell(int x, int y) {
        synchronized (board[x][y]) {
            boolean isLocked = false;
            try {
                isLocked = board[x][y].tryLock(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isLocked) {
                System.out.println(String.format("Cell %s x %s is locked by %s thread", x, y, Thread.currentThread().getName()));
            } else {
                System.out.println(String.format("Cell %s x %s is not locked by %s thread", x, y, Thread.currentThread().getName()));
            }
            return isLocked;
        }
    }

    /**
     * Метод для получения высоты игрового поля.
     * @return высота игрового поля.
     */
    public synchronized int getHeight() {
        return board.length;
    }

    /**
     * Метод для получения ширины игрового поля.
     * @return ширина игрового поля.
     */
    public synchronized int getWidth() {
        return board[0].length;
    }

    /**
     * Метод для освобождения ячейки игрового поля.
     * @param x координата ячейки по оси абсцисс.
     * @param y координата ячейки по оси ординат.
     */
    public void unlockCell(int x, int y) {
        synchronized (board[x][y]) {
            board[x][y].unlock();
            System.out.println(String.format("Cell %s x %s is unlocked by %s thread", x, y, Thread.currentThread().getName()));
        }
    }
}
