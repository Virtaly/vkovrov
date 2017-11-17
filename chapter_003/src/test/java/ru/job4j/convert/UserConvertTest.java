package ru.job4j.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса ConvertList.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class UserConvertTest {

    /**
     * Тест для метода process.
     * Метод должен вернуть карту с пользователями.
     */
    @Test
    public void whenProcessUserListThenResultUserMap() {
        UserConvert convert = new UserConvert();
        List<User> userList = new ArrayList<>();
        userList.add(new User(100, "Sasha", "Tomsk"));
        userList.add(new User(101, "Masha", "New York"));
        userList.add(new User(102, "Vitia", "Moscow"));
        userList.add(new User(103, "Artur", "Saint-Petersburg"));
        userList.add(new User(104, "Michel", "San Francisco"));
        HashMap<Integer, User> userMap =  convert.process(userList);
        String result = Arrays.toString(userMap.keySet().toArray());
        String expected = "[100, 101, 102, 103, 104]";
        assertThat(result, is(expected));
    }
}