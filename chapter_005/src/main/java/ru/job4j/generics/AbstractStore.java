package ru.job4j.generics;

/**
 * Класс для описания абстрактного хранилища.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <T> тип хранимых в хранилище объектов.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    /**
     * Поле структуры данных для хранения пользователей.
     */
    private SimpleArray<T> array;

    /**
     * Констурктор класса.
     * @param size размер структуры данных.
     */
    public AbstractStore(int size) {
        array = new SimpleArray<>(size);
    }

    /**
     * Метод для добавления элемента в хранилище.
     * @param model элемент.
     * @return добавляемый элемент.
     */
    @Override
    public T add(T model) {
        array.add(model);
        return model;
    }

    /**
     * Метод для обновления элемента.
     * @param model элемент для обновления.
     * @return обновленный элемент.
     */
    @Override
    public T update(T model) {
        for (int i = 0; i < this.array.getLength(); i++) {
            if (array.get(i).getId().equals(model.getId())) {
                array.update(i, model);
                break;
            }
        }
        return model;
    }

    /**
     * Метод для удаления элемента из хранилища.
     * @param id идентификатор элемента.
     * @return удалился ли элемент.
     */
    @Override
    public boolean delete(String id) {
        boolean wasDeleted = false;
        for (int i = 0; i < this.array.getLength(); i++) {
            if (array.get(i).getId().equals(id)) {
                array.delete(i);
                wasDeleted = true;
                break;
            }
        }
        return wasDeleted;
    }

    /**
     * Метод для получения элемента из хранилища.
     * @param id идентификатор элемента.
     * @return элемент хранилища.
     */
    @Override
    public T get(String id) {
        T item = null;
        for (int i = 0; i < this.array.getLength(); i++) {
            if (array.get(i).getId().equals(id)) {
                item = array.get(i);
                break;
            }
        }
        return item;
    }
}
