package ru.job4j.bank;

/**
 * Класс для описания аккаунта.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Account {

    /**
     * Поле для суммы денег хранимой на счете.
     */
    private double value;

    /**
     * Поле для реквизитов аккаунта.
     */
    private long requisites;

    /**
     * Конструктор класса.
     * @param requisites реквизиты аккаунта.
     */
    public Account(long requisites) {
        this.requisites = requisites;
        this.value = 0;
    }

    /**
     * Метод для перевода денег на другой счет.
     * @param dstAccount счет назначения перевода.
     * @param amount сумма перевода.
     * @return выполнился ли перевод.
     */
    public boolean transferAmount(Account dstAccount, double amount) {
        boolean transferSuccess = false;
        if (this.value >= amount) {
            this.takeAmount(amount);
            transferSuccess = dstAccount.putAmount(amount);
        }
        return transferSuccess;
    }

    /**
     * Метод для пополнения счета.
     * @param amount сумма.
     * @return выполнилось ли пополнение счета.
     */
    public boolean putAmount(double amount) {
        this.value += amount;
        return true;
    }

    /**
     * Метод для снятия денег со счета.
     * @param amount сумма.
     * @return выполнилось ли снятие со счета.
     */
    public boolean takeAmount(double amount) {
        this.value -= amount;
        return true;
    }

    /**
     * Метод для сравнения двух объектов.
     * @param o объект для сравнения с текущим.
     * @return равенство объектов.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return requisites == account.requisites;
    }

    /**
     * Метод для вычисления хеш-кода объекта.
     * @return хеш-код объекта.
     */
    @Override
    public int hashCode() {
        return (int) (requisites ^ (requisites >>> 32));
    }

    /**
     * Метод для строкового представления объекта.
     * @return строка, описывающая объект.
     */
    @Override
    public String toString() {
        return "Account{"
                + "value=" + value
                + ", requisites=" + requisites
                + '}';
    }
}
