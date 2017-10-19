package ru.job4j.professions;

/**
 * Класс Teacher для описания профессии учителя.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Teacher extends Profession {
    /**
     * Массив классов учеников, в которых преподает учитель.
     */
    private PupilsClass[] classesToWork;

    /**
     * Конструктор для класса Teacher.
     * @param spec узкая специализация.
     * @param salary зарплата.
     * @param classes массив классов учеников, в которых преподает учитель
     */
    public Teacher(String spec, int salary, PupilsClass[] classes) {
        super(spec, salary);
        this.classesToWork = classes;
    }

    /**
     * Метод для вызова ученика к доске.
     * @param pupil ученик.
     */
    public void callToTheBlackBoard(Pupil pupil) {
        System.out.println("Эй, " + pupil + " быстро к доске, хватит играть в айфон.");
    }

    /**
     * Метод для задания домашнего задания классу учеников.
     * @param pupilsClass класс учеников.
     */
    public void setHomework(PupilsClass pupilsClass) {
        System.out.println("Итак, " + pupilsClass + ", наш урок подходит к концу ...");
        System.out.println("И сейчас я задам кучу упражнений на дом, ");
        System.out.println("потому что у меня нет личной жизни, следовательно, и у вас быть не должно, максимум кошка.");
        System.out.println("Задает домашнее задание ...");
        System.out.println("На этом все, хороших выходный " + pupilsClass);
    }

    /**
     * Метод для проверки домашнего задания у ученика.
     * @param pupil ученик.
     * @return оценка.
     */
    public Mark checkHomework(Pupil pupil) {
        System.out.println("Так, что мы имеем, субботний вечер и проверку домашнего задания ...");
        System.out.println("Как бы не умереть от счастья. Чья тут у нас следующая тетрадь, ага эта " + pupil);
        System.out.print("Она красивая, глупая, и встречается с футболистом, а у меня только кот. ");
        System.out.println("Поставлю ей 2");
        Mark markTwo = new Mark();
        System.out.println("Пусть идет учиться в ПТУ");
        return markTwo;
    }

    /**
     * Геттер для массива классов учеников, в которых преподает учитель.
     * @return массив классов учеников.
     */
    public PupilsClass[] getClassesToWork() {
        return this.classesToWork;
    }
}

/**
 * Класс для класса учеников.
 */
class PupilsClass {

}

/**
 * Класс для ученика.
 */
class Pupil {

}

/**
 * Класс для оценки.
 */
class Mark {

}