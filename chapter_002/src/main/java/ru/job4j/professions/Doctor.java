package ru.job4j.professions;

/**
 * Класс Doctor для описания профессии доктора.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Doctor extends Profession {

    /**
     * Медсестра, прикрепленная к доктору.
     */
    private Nurse personalNurse;

    /**
     * Номер кабинета доктора.
     */
    private int cabinetNumber;

    /**
     * Конструктор класса Doctor.
     * @param spec узкая специализация врача.
     * @param salary зарплата врача.
     * @param personalNurse медсестра, прикрепленная к врачу.
     * @param cabinetNumber кабинет врача.
     */
    public Doctor(String spec, int salary, Nurse personalNurse, int cabinetNumber) {
        super(spec, salary);
        this.personalNurse = personalNurse;
        this.cabinetNumber = cabinetNumber;
    }

    /**
     * Метод для выслушивания жалоб пациента.
     * @param patient пациент.
     */
    public void listenProblem(Patient patient) {

    }

    /**
     * Метод для лечения пациента.
     * @param patient пациент.
     */
    public void treatPatient(Patient patient) {

    }

    /**
     * Геттер для медсестры, прикрепленной к доктору.
     * @return медсестра, прикрепленная к доктору.
     */
    public Nurse getPersonalNurse() {
        return this.personalNurse;
    }

    /**
     * Геттер для номера кабинета, в котором работает доктор.
     * @return номер кабинета доктора.
     */
    public int getCabinetNumber() {
        return this.cabinetNumber;
    }
}

/**
 * Класс для медсестры.
 */
class Nurse {

}

/**
 * Класс для пациента.
 */
class Patient {

}