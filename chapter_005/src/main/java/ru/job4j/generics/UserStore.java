package ru.job4j.generics;

/**
 * Класс для описания хранилища пользователей.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class UserStore extends AbstractStore<User> {

    /**
     * Констурктор класса.
     * @param size размер структуры данных.
     */
    public UserStore(int size) {
        super(size);
    }
}
