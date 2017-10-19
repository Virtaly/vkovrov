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
        System.out.println("Здравствуйте, " + patient);
        System.out.println("Расскажите мне про ваши проблемы, мне ведь так интересно");
        System.out.println("Да-да, я вас внимательно слушаю, как вы вообще еще живы, феноменально");
    }

    /**
     * Метод для лечения пациента.
     * @param patient пациент.
     */
    public void treatPatient(Patient patient) {
        System.out.println("Значит," + patient + ", вы говорите что у вас сломана нога, вы уверены?");
        System.out.println("Ну давайте посмотрим ... ");
        System.out.println("а может она всегда была с синеватым оттенком, просто вы не замечали?");
        System.out.println("Ну ладно, давайте сделаю как было ... *хрусь*");
        System.out.println("Почему вы плачете, мужики не должны плакать ... а вы девушка, просто коротко постриглись?");
        System.out.println("Ну это, краситься начните хотябы");
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