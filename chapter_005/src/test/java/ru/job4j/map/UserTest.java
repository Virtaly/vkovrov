package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест для класса User.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class UserTest {

    /**
     * Поле для структуры данных.
     */
    private Map<User, Object> container;

    /**
     * Поле для первого пользователя.
     */
    private User firstUser;

    /**
     * Поле для второго пользователя.
     */
    private User secondUser;

    /**
     * Метод для создания структуры данных и пользователей перед запуском тестов.
     */
    @Before
    public void setUp() {
        container = new HashMap<>();
        firstUser = new User("Vitaly", 0, new GregorianCalendar(1994, 9, 19));
        secondUser = new User("Vitaly", 0, new GregorianCalendar(1994, 9, 19));

    }

    /**
     * Тест для метода put.
     * Метод должен перезаписать элемент.
     */
    @Test
    public void whenPutTwoSimilarUsersWithHashCodeAndEqualsThenRestore() {
        container.put(firstUser, new Object());
        container.put(secondUser, new Object());
        System.out.println(container);
        assertThat(container.size(), is(1));
    }
}