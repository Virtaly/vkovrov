package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Класс для сортировки пользователей.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class SortUser {

    /**
     * Метод для сортировки пользователей.
     * @param list список пользователей.
     * @return отсортированное множество пользователей.
     */
    public Set<User> sort(List<User> list) {
        Set<User> set = new TreeSet<>();
        set.addAll(list);
        return set;
    }
}
