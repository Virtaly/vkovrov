package ru.job4j.jmm;

import org.junit.Before;
import org.junit.Test;

/**
 * Тест для класса RaceConditionProblem.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class RaceConditionProblemTest {

    /**
     * Поле объекта, демонстрирующего проблему условия гонок.
     */
    private RaceConditionProblem raceProblem;

    /**
     * Метод для создания объекта демонстрации проблемы перед запуском тестов.
     */
    @Before
    public void setUp() {
        raceProblem = new RaceConditionProblem();
    }

    /**
     * Тест для метода showVisibilityProblem.
     * Демонстрирует, что после изменения первым потоком полей общего объекта,
     * второй поток не получает эти изменения.
     */
    @Test
    public void whenShowRaceProblemThenChangesArentSaved() {
        raceProblem.showRaceConditionProblem();
    }
}