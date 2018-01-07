package ru.job4j.threads;

import org.junit.Before;
import org.junit.Test;

/**
 * Тест для класса CountCharTest.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class CountCharTest {

    /**
     * Поток для счетчика букв.
     */
    private Thread countCharThread;

    /**
     * Поток для прерывания программы после допустимого времени ее выполнения.
     */
    private Thread timeThread;

    /**
     * Метод для создания счетчика перед запуском тестов.
     */
    @Before
    public void setUp() {
        countCharThread = new Thread(new CountChar("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tempus fermentum volutpat. In ullamcorper, lectus eget pellentesque pulvinar, odio neque volutpat nunc, non porta enim dolor a nunc. Quisque vitae feugiat tortor. Sed in turpis mollis, feugiat nulla at, blandit lectus. Quisque placerat dui maximus justo porta, id vehicula sapien egestas. Etiam sit amet massa ligula. Donec leo dui, auctor ac nulla id, iaculis vulputate purus. Donec consectetur mauris quis porttitor cursus. Nam finibus metus felis, eu cursus odio posuere et. Nunc egestas placerat pulvinar. Suspendisse orci massa, malesuada vel tincidunt eu, lacinia eu justo. Nullam eget elementum magna. Pellentesque sit amet quam quis dui semper pulvinar. Nulla id felis nulla. Pellentesque quis est posuere, tincidunt nulla in, venenatis ipsum.\n"
                + "Nullam commodo maximus rhoncus. Fusce ac nisl neque. Pellentesque faucibus volutpat auctor. Aenean maximus ultrices tempor. Praesent viverra risus eu mollis tempor. Donec tempus nulla id orci consequat dapibus. Nulla facilisi. Pellentesque suscipit tincidunt tempor. Aliquam euismod nec metus sed viverra.\n"
                + "Donec porta rhoncus ante, in lacinia tellus aliquam quis. Praesent bibendum ex ac vestibulum dictum. Sed orci turpis, placerat ut metus at, consectetur tristique felis. Donec posuere tortor in lorem faucibus, vel faucibus nunc tincidunt. Nam quis laoreet diam. Aliquam rutrum quis erat et accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed et arcu eget nunc suscipit facilisis. Pellentesque eleifend commodo eleifend. Vivamus ut faucibus ligula. Nunc blandit bibendum orci, et egestas sem elementum sit amet."));
        timeThread = new Thread(new Time(1, countCharThread));
    }

    /**
     * Тест для метода count.
     */
    @Test
    public void whenCountWordsAndSpacesThenCountParallel() {
        timeThread.start();
        countCharThread.start();
        try {
            timeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}