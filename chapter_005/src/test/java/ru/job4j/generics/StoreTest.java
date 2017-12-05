package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для интерфейса Store.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class StoreTest {

    /**
     * Поле для хранилища пользователей.
     */
    private Store<User> userStore;

    /**
     * Поле для хранилища ролей.
     */
    private Store<Role> roleStore;

    /**
     * Метод для создания хранилищ перед запуском тестов.
     */
    @Before
    public void setUp() {
        userStore = new UserStore(10);
        userStore.add(new User("111", "First user"));
        userStore.add(new User("222", "Second user"));
        userStore.add(new User("333", "Third user"));

        roleStore = new RoleStore(10);
        roleStore.add(new Role("111", "First role"));
        roleStore.add(new Role("222", "Second role"));
        roleStore.add(new Role("333", "Third role"));

    }


    /**
     * Тест для метода add.
     * Метод должен добавить по элементу в каждое хранилище.
     */
    @Test
    public void whenAddThreeElementsThenArrayHasSixthElement() {
        userStore.add(new User("444", "Fourth user"));
        roleStore.add(new Role("444", "Fourth role"));
        assertThat(userStore.get("444"), is(new User("444", "Fourth user")));
        assertThat(roleStore.get("444"), is(new Role("444", "Fourth role")));
    }

    /**
     * Тест для метода update.
     * Метод должен обновить второй элемент.
     */
    @Test
    public void whenUpdateElementThenArrayHasThisElement() {
        userStore.update(new User("222", "Updated second user"));
        roleStore.update(new Role("222", "Updated second role"));
        assertThat(userStore.get("222"), is(new User("222", "Updated second user")));
        assertThat(roleStore.get("222"), is(new Role("222", "Updated second role")));
    }

    /**
     * Тест для метода delete.
     * Метод должен удалить первый элемент.
     */
    @Test
    public void whenDeleteElementThenArrayHasntThisElement() {
        assertThat(userStore.delete("111"), is(true));
        assertThat(roleStore.delete("111"), is(true));
    }
}