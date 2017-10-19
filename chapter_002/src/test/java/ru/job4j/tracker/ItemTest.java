package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса Item.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class ItemTest {

    /**
     * Тест для метода addComment.
     * После добавления заявке второго комментария "Second Comment",
     * в массиве комментариев к заявке этот комментарий должен быть и быть вторым.
     */
    @Test
    public void addComment() {
        Item item = new Item("First item", "First Description", 123L);
        item.addComment("First Comment");
        item.addComment("Second Comment");
        String result = item.getComments()[1];
        String expected = "Second Comment";
        assertThat(result, is(expected));
    }

}