package ru.job4j.bomberman;

/**
 * Класс для героя игры.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Character implements Runnable {

    /**
     * Поле для игрового поля.
     */
    private final GameField field;

    /**
     * Поле для координаты по оси абсцисс последней занятой ячейки поля.
     */
    private int lastX;

    /**
     * Поле для координаты по оси ординат последней занятой ячейки поля.
     */
    private int lastY;

    /**
     * Конструктор класса.
     * @param field игровое поле.
     */
    public Character(GameField field) {
        this.field = field;
    }

    /**
     * Метод для движения персонажа по полю.
     */
    private void move() {
        boolean firstEnter = true;
        while (true) {
            for (int x = 0; x < this.field.getHeight(); x++) {
                for (int y = 0; y < this.field.getWidth(); y++) {
                    if (field.lockCell(x, y)) {
                        if (!firstEnter) {
                            field.unlockCell(this.lastX, this.lastY);
                        }
                        this.lastX = x;
                        this.lastY = y;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        firstEnter = false;
                    }
                }
            }
        }
    }

    /**
     * Метод для поведения героя после запуска его потока.
     */
    @Override
    public void run() {
        this.move();
    }
}
