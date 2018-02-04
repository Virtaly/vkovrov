package ru.job4j.nonblocking;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса Cache.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class CacheTest {

    /**
     * Поле для кэша.
     */
    private Cache cache;

    /**
     * Метод для создания объекта кэша перед запуском тестов.
     */
    @Before
    public void setUp() {
        cache = new Cache();
    }


    /**
     * Тест для методов add и delete.
     */
    @Test
    public void whenAddOrDeleteElementsThenCacheSizeChanges() {
        cache.add(new Model(1, "Rectangle"));
        cache.add(new Model(2, "Square"));
        cache.add(new Model(3, "Cube"));
        assertThat(cache.getSize(), is(3));
        cache.delete(1);
        assertThat(cache.getSize(), is(2));
    }

    /**
     * Тест для метода update.
     */
    @Test
    public void whenUpdateModelThenModelHasNextVersion() {
        cache.add(new Model(1, "Rectangle"));
        Model model = new Model(1, "Sphere");
        cache.update(model);
        assertThat(cache.getModel(model.getKey()).getVersion(), is(2));
    }
}