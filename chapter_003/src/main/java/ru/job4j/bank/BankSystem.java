package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Класс для описания банковской системы.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class BankSystem {

    /**
     * Поле для хранения карты пар пользователь - список аккаунтов.
     */
    private Map<User, List<Account>> users;

    /**
     * Конструктор класса.
     * @param users карта пар пользователь - список аккаунтов
     */
    public BankSystem(Map<User, List<Account>> users) {
        this.users = users;
    }

    /**
     * Метод для добавления пользователя в систему.
     * @param user новый пользователь.
     */
    public void addUser(User user) {
        if (users != null) {
            this.users.putIfAbsent(user, new ArrayList<>());
        }

    }

    /**
     * Метод для удаления пользователя из системы.
     * @param user удаляемый пользователь.
     */
    public void deleteUser(User user) {
        if (user != null && users.containsKey(user)) {
            users.remove(user);
        }
    }

    /**
     * Метод для добавления аккаунта пользователю системы.
     * @param user пользователь системы.
     * @param account новый аккаунт.
     */
    public void addAccountToUser(User user, Account account) {
        if (user != null && users.containsKey(user) && account != null) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод для удаления аккаунта пользователя системы.
     * @param user пользователь системы.
     * @param account удаляемый аккаунт.
     */
    public void deleteAccountFromUser(User user, Account account) {
        if (user != null && users.containsKey(user) && account != null && users.get(user).contains(account)) {
            users.get(user).remove(account);
        }
    }

    /**
     * Метод для получения аккаунтов пользователя.
     * @param user пользователь системы.
     * @return список аккаунтов пользователя.
     */
    public List<Account> getUserAccounts(User user) {
        List<Account> accounts = null;
        if (user != null && users.containsKey(user)) {
            accounts = users.get(user);
        }
        return accounts;
    }

    /**
     * Метод для перевода денег.
     * @param srcUser пользователь, который переводит деньги.
     * @param srcAccount акаунт, с которого пользователь переводит деньги.
     * @param dstUser пользователь, которому переводят деньги.
     * @param dstAccount аккаунт, на который пользователь получает деньги.
     * @param amount сумма перевода.
     * @return выполнилась ли операция перевода.
     */
    public boolean transferMoney(
            User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean transferSuccess = false;
        if (users.containsKey(srcUser) && users.containsKey(dstUser)
                && users.get(srcUser).contains(srcAccount) && users.get(dstUser).contains(dstAccount)) {
            transferSuccess = srcAccount.transferAmount(dstAccount, amount);
        }
        return transferSuccess;
    }


}
