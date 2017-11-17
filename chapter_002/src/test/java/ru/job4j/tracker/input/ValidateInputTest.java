package ru.job4j.tracker.input;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.StartUi;
import ru.job4j.tracker.Tracker;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса ValidateInput.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */
public class ValidateInputTest {
    /**
     * Тест для метода addItem.
     * С помощью объекта StubInput добавляется одна задача, она должна присутствовать в трекере.
     * Ввод пользователя проверяется объектом ValidateInput.
     *
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new ValidateInput(new StubInput(
                new String[]{"-1", "0", "First task", "First description", "!wrongEnter!", "6"}));
        new StartUi(input, tracker).init();
        String result = tracker.findAll().get(0).getName();
        String expected = "First task";
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода findAll.
     * С помощью объекта StubInput на экран выводится строковое представление добавленной в трекер задачи,
     * ее представление для вывода на экран должно совпадать со строковым представлением.
     * Ввод пользователя проверяется объектом ValidateInput.
     */
    @Test
    public void whenUserAddItemThenTrackerShowOneItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("First task", "First description", System.currentTimeMillis());
        tracker.addItem(item);
        Input input = new ValidateInput(new StubInput(new String[]{"-10", "1", "!wrongEnter!", "6"}));
        new StartUi(input, tracker).init();
        List<Item> itemsArr = tracker.findAll();
        String result = "";
        for (Item itemToString : itemsArr) {
            result += itemToString.toString();
        }
        String expected = item.toString();
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода editName.
     * С помощью объекта StubInput изменяется имя задачи,
     * после этого имя задачи в трекере должно быть обновлено.
     * Ввод пользователя проверяется объектом ValidateInput.
     */
    @Test
    public void whenUserEditNameOfItemThenTrackerHasThisItemWithUpdatedName() {
        Tracker tracker = new Tracker();
        Item item = new Item("First task", "First description", System.currentTimeMillis());
        tracker.addItem(item);
        Input input = new ValidateInput(new StubInput(
                new String[]{"-100", "2", tracker.findAll().get(0).getId(), "!wrongEnter!", "0", "First task v2", "-100", "3", "!wrongEnter!", "6"}));
        new StartUi(input, tracker).init();
        String result = tracker.findAll().get(0).getName();
        String expected = "First task v2";
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода editDescription.
     * С помощью объекта StubInput изменяется описание задачи,
     * после этого описание задачи в трекере должно быть обновлено.
     * Ввод пользователя проверяется объектом ValidateInput.
     */
    @Test
    public void whenUserEditDescriptionOfItemThenTrackerHasThisItemWithUpdatedDescription() {
        Tracker tracker = new Tracker();
        Item item = new Item("First task", "First description", System.currentTimeMillis());
        tracker.addItem(item);
        Input input = new ValidateInput(new StubInput(
                new String[]{"!wrongEnter!", "2", tracker.findAll().get(0).getId(), "-1000", "1", "First description v2", "-100", "3", "!wrongEnter!", "6"}));
        new StartUi(input, tracker).init();
        String result = tracker.findAll().get(0).getDescription();
        String expected = "First description v2";
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода addComment.
     * С помощью объекта StubInput к задаче добавляется комментарий,
     * после этого он должен присутствовать у задачи в трекере.
     * Ввод пользователя проверяется объектом ValidateInput.
     */
    @Test
    public void whenUserAddCommentToItemThenTrackerHasThisItemWithUpdatedComments() {
        Tracker tracker = new Tracker();
        Item item = new Item("First task", "First description", System.currentTimeMillis());
        tracker.addItem(item);
        Input input = new ValidateInput(new StubInput(
                new String[]{"!wrongEnter!", "2", tracker.findAll().get(0).getId(), "-10000", "2", "First comment", "-10000", "3", "!wrongEnter!", "6"}));
        new StartUi(input, tracker).init();
        String result = tracker.findAll().get(0).getComments()[0];
        String expected = "First comment";
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода deleteItem.
     * С помощью объекта StubInput удаляется одна задача,
     * задачи с id удаленной задачи больше не должно быть в трекере.
     * Ввод пользователя проверяется объектом ValidateInput.
     */
    @Test
    public void whenUserDeleteItemThenTrackerHasNotThisItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("First task", "First description", System.currentTimeMillis());
        tracker.addItem(item);
        Input input = new ValidateInput(new StubInput(
                new String[]{"!wrongEnter!", "3", item.getId(), "-10000", "6"}));
        new StartUi(input, tracker).init();
        Item result = tracker.findById(item.getId());
        Item expected = null;
        assertThat(result, is(expected));
    }

    /**
     * Тест для метода findById.
     * С помощью объекта StubInput производится поиск ранее добавленной задачи по ее id,
     * она должна присутствовать в трекере.
     * Ввод пользователя проверяется объектом ValidateInput.
     */
    @Test
    public void whenUserAddItemThenTrackerFindThisItemById() {
        Tracker tracker = new Tracker();
        Item item = new Item("First task", "First description", System.currentTimeMillis());
        tracker.addItem(item);
        Input input = new ValidateInput(new StubInput(
                new String[]{"-10000", "4", tracker.findAll().get(0).getId(), "!wrongEnter!", "6"}));
        new StartUi(input, tracker).init();
        Item result = tracker.findById(item.getId());
        Item expected = item;
        assertThat(result.toString(), is(expected.toString()));
    }

    /**
     * Тест для метода findByName.
     * С помощью объекта StubInput производится поиск ранее добавленных задач по имени,
     * две задачи с одним именем должны присутствовать в трекере.
     * Ввод пользователя проверяется объектом ValidateInput.
     */
    @Test
    public void whenUserAddTwoItemsWithSameNameThenTrackerFindTwoItemsWithThisName() {
        Tracker tracker = new Tracker();
        Item item = new Item("First task", "First description", System.currentTimeMillis());
        tracker.addItem(item);
        item = new Item("First task", "Second description", System.currentTimeMillis());
        tracker.addItem(item);
        Input input = new ValidateInput(new StubInput(
                new String[]{"-10000", "5", "First task", "!wrongEnter!", "6"}));
        new StartUi(input, tracker).init();
        int result = tracker.findByName(item.getName()).size();
        int expected = 2;
        assertThat(result, is(expected));
    }
}