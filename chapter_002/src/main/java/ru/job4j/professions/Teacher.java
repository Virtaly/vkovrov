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

    }

    /**
     * Метод для задания домашнего задания классу учеников.
     * @param pupilsClass класс учеников.
     */
    public void setHomework(PupilsClass pupilsClass) {

    }

    /**
     * Метод для проверки домашнего задания у ученика.
     * @param pupil ученик.
     * @return оценка.
     */
    public Mark checkHomework(Pupil pupil) {
        return null;
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