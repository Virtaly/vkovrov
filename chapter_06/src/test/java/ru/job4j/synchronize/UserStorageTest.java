package ru.job4j.synchronize;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса UserStorage.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class UserStorageTest {

    /**
     * Поле для хранилища пользователей.
     */
    private UserStorage storage;

    /**
     * Метод для создания хранилища пользователей перед запуском тестов.
     */
    @Before
    public void setUp() {
        this.storage = new UserStorage();
        this.storage.add(new User(1, 100));
        this.storage.add(new User(2, 0));
    }

    /**
     * Класс для потока перевода денег.
     * @author vkovrov
     * @version 0.1
     * @since 0.1
     */
    private class TransferThread extends Thread {

        /**
         * Поле для хранилища пользователей.
         */
        private final UserStorage storage;

        /**
         * Конструктор класса.
         * @param storage хранилище пользователей.
         */
        private TransferThread(UserStorage storage) {
            this.storage = storage;
        }

        /**
         * Метод для запуска потока на выполнение.
         */
        @Override
        public void run() {
            this.storage.transfer(1, 2, 50);
        }
    }


    /**
     * Тест для метода transfer.
     * Использование метода для работы двух потоков с общим ресурсом.
     */
    @Test
    public void whenExecute2ThreadThen2() {
        Thread firstThread = new TransferThread(storage);
        Thread secondThread = new TransferThread(storage);
        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        assertThat(storage.getUserById(1).getAmount(), is(0));
        assertThat(storage.getUserById(2).getAmount(), is(100));
    }
}