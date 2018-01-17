package ru.job4j.synchronize;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;

/**
 * Класс для структуры данных для хранения пользователей.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
@ThreadSafe
public class UserStorage {

    /**
     * Поле для структуры данных для хранения пользователей.
     */
    @GuardedBy("this")
    private HashMap<Integer, User> userMap;

    /**
     * Конструктор класса.
     */
    public UserStorage() {
        this.userMap = new HashMap<>();
    }

    /**
     * Метод для получения пользователя по идентификатору.
     * @param id идентификатор пользователя.
     * @return пользователь.
     */
    public synchronized User getUserById(int id) {
        return userMap.get(id);
    }

    /**
     * Метод для добавления пользователя в хранилище.
     * @param user пользователь.
     * @return true, если пользователь добавился.
     */
    public synchronized boolean add(User user) {
        return userMap.putIfAbsent(user.getId(), user) != null;
    }

    /**
     * Метод для обновления пользователя в хранилище.
     * @param user пользователь.
     * @return true, если пользователь обновился.
     */
    public synchronized boolean update(User user) {
        boolean isUpdated = false;
        if (userMap.containsKey(user.getId())) {
            userMap.put(user.getId(), user);
            isUpdated = true;
        }
        return isUpdated;
    }

    /**
     * Метод для удаления пользователя из хранилища.
     * @param user пользователь.
     * @return true, если пользователь удалился.
     */
    public synchronized boolean delete(User user) {
        return userMap.remove(user) != null;
    }

    /**
     * Метод для перевода денег от одного пользователя другому.
     * @param fromId идентификатор переводчика.
     * @param toId идентификатор получателя.
     * @param amount сумма.
     * @return true, если перевод прошел успешно.
     */
    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean transferSuccess = false;
        User fromUser = userMap.get(fromId);
        User toUser = userMap.get(toId);
        if (fromUser.reduceAmount(amount)) {
            toUser.riseAmount(amount);
            transferSuccess = true;
        }
        return transferSuccess;
    }

}

/**
 * Класс для описания пользователя.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
class User {

    /**
     * Уникальный идентификатор пользователя.
     */
    private int id;

    /**
     * Сумма на счете пользователя.
     */
    private int amount;

    /**
     * Конструктор класса.
     * @param id идентификатор пользователя.
     * @param amount сумма на счете пользователя.
     */
    User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Метод для понижения суммы на счете.
     * @param amount значение, на которое нужно понизить сумму на счете.
     * @return true, если сумма на счете понижена.
     */
    public boolean reduceAmount(int amount) {
        boolean isReduced = false;
        if (this.amount >= amount) {
            this.amount -= amount;
            isReduced = true;
        }
        return isReduced;
    }

    /**
     * Метод для повышения суммы на счете.
     * @param amount значение, на которое нужно повысить сумму на счете.
     */
    public void riseAmount(int amount) {
        this.amount += amount;
    }

    /**
     * Геттер для идентификатора пользователя.
     * @return идентификатор пользователя.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Геттер для суммы на счете.
     * @return сумма на счете.
     */
    public int getAmount() {
        return this.amount;
    }
}