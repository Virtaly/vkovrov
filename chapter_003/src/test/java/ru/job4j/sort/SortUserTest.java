package ru.job4j.sort;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса ConvertList.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */

public class SortUserTest {

    /**
     * Тест для метода sort.
     * Метод должен вернуть отсортированное множество пользователей по возрасту.
     */
    @Test
    public void whenSortUserListThenReturnSortedSet() {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Vitaly", 23),
                new User("Misha", 22),
                new User("Lera", 24)));
        String result = new SortUser().sort(users).toString();
        String expected = "[Misha is 22, Vitaly is 23, Lera is 24]";
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода sort.
     * Метод должен вернуть отсортированное множество пользователей по возрасту,
     * даже если возраст одинаковый.
     */
    @Test
    public void whenSortUserListWithSameAgesThenReturnSortedSet() {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Vitaly", 23),
                new User("Misha", 23),
                new User("Lera", 24)));
        String result = new SortUser().sort(users).toString();
        String expected = "[Misha is 23, Vitaly is 23, Lera is 24]";
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода sortNameLength.
     * Метод должен вернуть отсортированный список пользователей по длине имени.
     */
    @Test
    public void whenSortUserListThenReturnNameLengthSortedList() {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Vitaly", 23),
                new User("Misha", 23),
                new User("Lera", 24)));
        String result = new SortUser().sortNameLength(users).toString();
        String expected = "[Lera is 24, Misha is 23, Vitaly is 23]";
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода sortByAllFields.
     * Метод должен вернуть отсортированный список пользователей о всем полям.
     */
    @Test
    public void whenSortUserListThenReturnAllFieldsSortedList() {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Vitaly", 23),
                new User("Vitaly", 25),
                new User("Misha", 23),
                new User("Misha", 23),
                new User("Aleksandra", 24)));
        String result = new SortUser().sortByAllFields(users).toString();
        String expected = "[Aleksandra is 24, Misha is 23, Misha is 23, Vitaly is 23, Vitaly is 25]";
        assertThat(result, is(expected));
    }
}