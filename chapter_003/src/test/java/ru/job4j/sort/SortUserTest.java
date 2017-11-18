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
}