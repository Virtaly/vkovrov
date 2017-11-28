package ru.job4j.bank;

import java.util.ArrayList;
import java.util.Collections;
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
            this.users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод для удаления пользователя из системы.
     * @param user удаляемый пользователь.
     */
    public void deleteUser(User user) {
            users.remove(user);
    }

    /**
     * Метод для добавления аккаунта пользователю системы.
     * @param user пользователь системы.
     * @param account новый аккаунт.
     */
    public void addAccountToUser(User user, Account account) {
            List<Account> accounts = users.get(user);
            if (accounts != null) {
                accounts.add(account);
            }
    }

    /**
     * Метод для удаления аккаунта пользователя системы.
     * @param user пользователь системы.
     * @param account удаляемый аккаунт.
     */
    public void deleteAccountFromUser(User user, Account account) {
        List<Account> accounts = users.get(user);
        if (accounts != null) {
            accounts.remove(account);
        }
    }

    /**
     * Метод для получения аккаунтов пользователя.
     * @param user пользователь системы.
     * @return список аккаунтов пользователя.
     */
    public List<Account> getUserAccounts(User user) {
        return users.getOrDefault(user, Collections.emptyList());
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
        List<Account> srcUserAccounts = users.get(srcUser);
        List<Account> dstUserAccounts = users.get(dstUser);
        if (srcUserAccounts != null && dstUserAccounts != null) {
            if (srcUserAccounts.contains(srcAccount) && dstUserAccounts.contains(dstAccount)) {
                transferSuccess = srcAccount.transferAmount(dstAccount, amount);
            }
        }
        return transferSuccess;
    }


}
