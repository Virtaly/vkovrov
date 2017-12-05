package ru.job4j.generics;

/**
 * Класс для описания хранилища ролей.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class RoleStore extends AbstractStore<Role> {

    /**
     * Констурктор класса.
     * @param size размер структуры данных.
     */
    public RoleStore(int size) {
        super(size);
    }


}
