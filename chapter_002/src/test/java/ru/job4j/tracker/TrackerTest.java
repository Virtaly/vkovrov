package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса Tracker.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class TrackerTest {

    /**
     * Тест для метода addItem.
     * После добавления одной заявки трекер, его поле position должно стать равным 1.
     */
    @Test
    public void whenAddOneItemThenPositionIsOne() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("First item", "Description for first item", 123L);
        tracker.addItem(firstItem);
        int expected = 1;
        int result = tracker.getPosition();
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода update.
     * После присвоения второй заявке уникального идентификатора первой заявки и ее обновления,
     * она должна перезаписать первую заявку.
     */
    @Test
    public void whenUpdateItemThenThisItemHasNewName() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("First item", "Description for first item", 123L);
        tracker.addItem(firstItem);
        Item secondItem = new Item("Second item", "Description for second item", 1234L);
        secondItem.setId(firstItem.getId());
        tracker.update(secondItem);
        String expected = "Second item";
        String result = tracker.findById(firstItem.getId()).getName();
        assertThat(expected, is(result));
    }

    /**
     * Тест для метода delete.
     * После добавления трех заявок в трекер и удаления одного элемента,
     * поле position объекта tracker должно стать равным 2.
     */
    @Test
    public void whenDeleteOneItemOfTheThreeThenPositionIsTwo() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("First item", "Description for first item", 123L);
        tracker.addItem(firstItem);
        Item secondItem = new Item("Second item", "Description for second item", 1234L);
        tracker.addItem(secondItem);
        Item thirdItem = new Item("Third item", "Description for third item", 1234L);
        tracker.addItem(thirdItem);
        tracker.delete(secondItem);
        int expected = 2;
        int result = tracker.getPosition();
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода findAll.
     * Метод должен вернуть массив со всеми заявками, добавленными ранее.
     */
    @Test
    public void whenItemsArrayHasThreeItemsThenReturnThreeItems() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("First item", "Description for first item", 123L);
        tracker.addItem(firstItem);
        Item secondItem = new Item("Second item", "Description for second item", 1234L);
        tracker.addItem(secondItem);
        Item thirdItem = new Item("Third item", "Description for third item", 1234L);
        tracker.addItem(thirdItem);
        Item[] expected = {firstItem, secondItem, thirdItem};
        Item[] result = tracker.findAll();
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода findByName.
     * Метод должен вернуть массив из двух элементов, т.к. первая и третья заявки содержат одинаковое имя.
     */
    @Test
    public void whenSearchForItemNameThenReturnArrayOfItemsWithThisName() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("First item", "Description for first item", 123L);
        tracker.addItem(firstItem);
        Item secondItem = new Item("Second item", "Description for second item", 1234L);
        tracker.addItem(secondItem);
        Item thirdItem = new Item("First item", "Description for third item", 1234L);
        tracker.addItem(thirdItem);
        Item[] result = tracker.findByName("First item");
        Item[] expected = {firstItem, thirdItem};
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода findId.
     * Метод должен найти в массиве заявок заявку по уникальному идентификатору и вернуть его.
     */
    @Test
    public void whenFindItemByIdThenReturnThisItem() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("First item", "Description for first item", 123L);
        tracker.addItem(firstItem);
        Item secondItem = new Item("Second item", "Description for second item", 1234L);
        tracker.addItem(secondItem);
        Item thirdItem = new Item("Third item", "Description for third item", 1234L);
        tracker.addItem(thirdItem);
        Item result = tracker.findById(secondItem.getId());
        Item expected = secondItem;
        assertThat(result, is(expected));
    }
}