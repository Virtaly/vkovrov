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
        System.out.println("Инженеру в тикет-системе приходит новый " + task);
        System.out.println("Инженер немного грустит, потом немного думает ...");
        System.out.println("Не придумав ничего похожего на решение, он ищет его в интернете ...");
        System.out.println("И вуаля ... программа готова");
        Program program = new Program();
        System.out.println("Теперь можно пойти выпить кофе и потом уже отправить код с помощью " + this.personalComputer);
        this.drinkCoffee(new Coffee());
        return program;
    }

    /**
     * Метод чтобы инженер пошел пообедал.
     * @param lunch обед.
     */
    public void eatLunch(Lunch lunch) {
        System.out.println("Инженер ушел на обед.");
        System.out.println("Инженер ест " + lunch);
        System.out.println("Инженер поел и думает стоит ли возвращаться на работу.");
        System.out.println("Инженер вспомнил про ипотеку и нехотя возвращается на работу");
    }

    /**
     * Метод чтобы инженер пошел выпил кофе.
     * @param latte кофе.
     */
    public void drinkCoffee(Coffee latte) {
        System.out.print("Инженер пошел за кофе, потому что он пофиксил баги и их стало еще больше, ");
        System.out.println("и вообще осень и хочется спать.");
        System.out.println("Инженер пьет кофе " + latte);
        System.out.println("Мозг начинает немножко шустрее работать и инженер возвращается к своим любимым багам");

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