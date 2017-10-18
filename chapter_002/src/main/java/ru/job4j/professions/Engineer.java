package ru.job4j.professions;

/**
 * Класс Engineer для описания профессии инженера.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Engineer extends Profession {

    /**
     * Персональный компьютер инженера.
     */
    private Computer personalComputer;

    /**
     * Конструктор класса Engineer.
     * @param spec узкая специализация инженера.
     * @param salary зарплата инженера.
     * @param personalComputer персональный компьютер инженера.
     */
    public Engineer(String spec, int salary, Computer personalComputer) {
        super(spec, salary);
        this.personalComputer = personalComputer;
    }

    /**
     * Метод для написания программы инженером.
     * @param task техническое задание на программу.
     * @return написанная инженером программа.
     */
    public Program writeProgram(String task) {
        return null;
    }

    /**
     * Метод чтобы инженер пошел пообедал.
     * @param lunch обед.
     */
    public void eatLunch(Lunch lunch) {

    }

    /**
     * Метод чтобы инженер пошел выпил кофе.
     * @param latte кофе.
     */
    public void drinkCoffee(Coffee latte) {

    }
}

/**
 * Класс для компьютера.
 */
class Computer {

}

/**
 * Класс для кофе.
 */
class Coffee {

}

/**
 * Класс для обеда.
 */
class Lunch {

}

/**
 * Класс для программы.
 */
class Program {

}