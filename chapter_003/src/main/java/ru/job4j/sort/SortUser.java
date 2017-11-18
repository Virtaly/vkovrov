package ru.job4j.sort;

import java.util.Comparator;
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

    /**
     * Метод для сортировки списка пользователей по длине имени.
     * @param list список пользователей.
     * @return отсортированный список.
     */
    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                boolean equal = o1.getName().length() == o2.getName().length();
                boolean more = o1.getName().length() > o2.getName().length();
                return equal ? 0 : (more ? 1 : -1);
            }
        });
        return list;
    }

    /**
     * Метод для сортировки пользователей по всем полям.
     * @param list список пользователей.
     * @return отсортированный список.
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName()) == 0
                        ? Integer.compare(o1.getAge(), o2.getAge()) : o1.getName().compareTo(o2.getName());
            }
        });
        return list;
    }
}
