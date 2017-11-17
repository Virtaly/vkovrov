package ru.job4j.convert;

import java.util.HashMap;
import java.util.List;

/**
 * Класс для конвертации коллекций, хранящих пользователей.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class UserConvert {

    /**
     * Метод для преобразования List в Map.
     * @param list список пользователей.
     * @return карта пользователей, где ключем выступает идентификатор пользователя.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> userMap = new HashMap<>();
        for (User user : list) {
            userMap.put(user.getId(), user);
        }
        return userMap;
    }
}
