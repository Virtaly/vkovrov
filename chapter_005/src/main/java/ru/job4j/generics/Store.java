package ru.job4j.generics;

/**
 * Интерфейс для описания поведения хранилища.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <T> тип хранимых в хранилище объектов.
 */
public interface Store<T extends Base> {

    /**
     * Метод для добавления элемента в хранилище.
     * @param model элемент.
     * @return добавляемый элемент.
     */
    T add(T model);

    /**
     * Метод для получения элемента из хранилища.
     * @param id идентификатор элемента.
     * @return элемент хранилища.
     */
    T get(String id);

    /**
     * Метод для обновления элемента.
     * @param model элемент для обновления.
     * @return обновленный элемент.
     */
    T update(T model);

    /**
     * Метод для удаления элемента из хранилища.
     * @param id идентификатор элемента.
     * @return удалился ли элемент.
     */
    boolean delete(String id);
}
