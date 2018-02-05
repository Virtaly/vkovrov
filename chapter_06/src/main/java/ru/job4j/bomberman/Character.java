package ru.job4j.bomberman;

import java.util.Random;

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
     * Поле для генератора рандомных чисел.
     */
    private static final Random RANDOM = new Random();

    /**
     * Конструктор класса.
     * @param field игровое поле.
     */
    public Character(GameField field) {
        this.field = field;
    }

    /**
     * Метод для поведения героя после запуска его потока.
     */
    @Override
    public void run() {
        while (true) {
            int x = RANDOM.nextInt(this.field.getHeight());
            int y = RANDOM.nextInt(this.field.getWidth());
            if (field.lockCell(x, y)) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    field.unlockCell(x, y);
                }
            }

        }
    }
}
