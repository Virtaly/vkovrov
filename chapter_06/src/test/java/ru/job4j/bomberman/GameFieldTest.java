package ru.job4j.bomberman;

import org.junit.Test;
import org.junit.Before;

/**
 * Тест для класса GameField.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class GameFieldTest {

    /**
     * Поле для игрового поля.
     */
    private GameField field;

    /**
     * Поле для потока первого героя.
     */
    private Thread firstCharacter;

    /**
     * Поле для потока второго героя.
     */
    private Thread secondCharacter;

    /**
     * Метод для создания объекта очереди перед запуском тестов.
     */
    @Before
    public void setUp() {
        this.field = new GameField(10, 10);
        this.firstCharacter = new Thread(new Character(this.field));
        this.firstCharacter.setName("firstCharacter");
        this.secondCharacter = new Thread(new Character(this.field));
        this.secondCharacter.setName("secondCharacter");

    }

    /**
     * Тест для методов добавления и извлечения данных из очереди двумя потоками.
     * По шаблону Producer-Consumer.
     */
    @Test
    public void test() {
        firstCharacter.start();
        secondCharacter.start();
        try {
            firstCharacter.join();
            secondCharacter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}