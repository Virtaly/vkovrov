package ru.job4j.bank;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса BankSystem.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class BankSystemTest {

    /**
     * Тест для метода deleteUser.
     * Метод должен удалить одного пользователя.
     */
    @Test
    public void whenDeleteOneUserThenMapHasOnlyOneUser() {
        Map<User, List<Account>> users = new HashMap<User, List<Account>>() { {
            put(new User("Misha", 12345), new ArrayList<>());
            put(new User("Pasha", 7891011), new ArrayList<>());
        } };
        BankSystem system = new BankSystem(users);
        system.deleteUser(new User("Misha", 12345));
        String result = users.toString();
        String expected = "{User{name='Pasha', passport=7891011}=[]}";
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода addUser.
     * Метод должен добавить одного пользователя.
     */
    @Test
    public void whenAddOneUserThenMapHasTwoUsers() {
        Map<User, List<Account>> users = new HashMap<User, List<Account>>() { {
            put(new User("Misha", 12345), new ArrayList<>());
        } };
        BankSystem system = new BankSystem(users);
        system.addUser(new User("Pasha", 7891011));
        String result = users.toString();
        String expected = "{User{name='Pasha', passport=7891011}=[], User{name='Misha', passport=12345}=[]}";
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода addAccountToUser.
     * Метод должен добавить один аккаунт для пользователя.
     */
    @Test
    public void whenAddOneAccountThenUserHasTwoAccounts() {
        Map<User, List<Account>> users = new HashMap<User, List<Account>>() { {
            put(new User("Misha", 12345), new ArrayList<Account>() { {
                add(new Account(400050006000L));
            } });
        } };
        BankSystem system = new BankSystem(users);
        system.addAccountToUser(new User("Misha", 12345), new Account(500050006000L));
        String result = users.toString();
        String expected = "{User{name='Misha', passport=12345}=[Account{value=0.0, requisites=400050006000}, Account{value=0.0, requisites=500050006000}]}";
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода deleteAccountFromUser.
     * Метод должен удалить один аккаунт у пользователя.
     */
    @Test
    public void whenDeleteOneAccountThenUserHasOneAccount() {
        Map<User, List<Account>> users = new HashMap<User, List<Account>>() { {
            put(new User("Misha", 12345), new ArrayList<Account>() { {
                add(new Account(400050006000L));
                add(new Account(500050006000L));
            } });
        } };
        BankSystem system = new BankSystem(users);
        system.deleteAccountFromUser(new User("Misha", 12345), new Account(500050006000L));
        String result = users.toString();
        String expected = "{User{name='Misha', passport=12345}=[Account{value=0.0, requisites=400050006000}]}";
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода getUserAccounts.
     * Метод должен вернуть список аккаунтов пользователя.
     */
    @Test
    public void whenGetUserAccountsThenUserAccountsList() {
        Map<User, List<Account>> users = new HashMap<User, List<Account>>() { {
            put(new User("Misha", 12345), new ArrayList<Account>() { {
                add(new Account(400050006000L));
                add(new Account(500050006000L));
            } });
        } };
        BankSystem system = new BankSystem(users);
        String result = system.getUserAccounts(new User("Misha", 12345)).toString();
        String expected = "[Account{value=0.0, requisites=400050006000}, Account{value=0.0, requisites=500050006000}]";
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода transferMoney.
     * Метод должен перевести деньги с аккаунта одного пользователя на аккаунт другого.
     */
    @Test
    public void whenTransferFromOneUserToAnotherThenTransferAmount() {
        Map<User, List<Account>> users = new HashMap<User, List<Account>>() { {
            put(new User("Misha", 12345), new ArrayList<Account>() { {
                add(new Account(400050006000L));
            } });
            put(new User("Pasha", 678910), new ArrayList<Account>() { {
                add(new Account(500050006000L));
            } });
        } };
        BankSystem system = new BankSystem(users);
        User srcUser = new User("Misha", 12345);
        User dstUser = new User("Pasha", 678910);
        system.getUserAccounts(srcUser).get(0).putAmount(100);
        system.transferMoney(srcUser, system.getUserAccounts(srcUser).get(0),
                dstUser, system.getUserAccounts(dstUser).get(0), 50);
        String result = system.getUserAccounts(dstUser).toString();
        String expected = "[Account{value=50.0, requisites=500050006000}]";
        assertThat(result, is(expected));
    }
}