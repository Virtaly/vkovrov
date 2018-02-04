package ru.job4j.nonblocking;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * Класс для неблокирующего кеша.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Cache {

    /**
     * Поле для хранилища.
     */
    private ConcurrentHashMap<Integer, Model> storage = new ConcurrentHashMap<>();

    /**
     * Метод для добавления модели в хранилище.
     * @param model новая модель.
     * @return true, если объект добавился.
     */
    public boolean add(Model model) {
        return storage.putIfAbsent(model.getKey(), model) == null;
    }

    /**
     * Метод для обновления модели в хранилище.
     * @param model обновленная модель.
     */
    public void update(Model model) {
        storage.computeIfPresent(model.getKey(), new BiFunction<Integer, Model, Model>() {
            @Override
            public Model apply(Integer integer, Model e) {
                if (model.getVersion() == e.getVersion()) {
                    e.setName(model.getName());
                } else {
                    try {
                        throw new OplimisticException("Data breach!");
                    } catch (OplimisticException e1) {
                        e1.printStackTrace();
                    }
                }
                return e;
            }
        });
    }

    /**
     * Метод для удаления модели из хранилища.
     * @param key идентификатор удаляемой модели.
     */
    public void delete(Integer key) {
        storage.remove(key);
    }

    /**
     * Геттер для размера кэша.
     * @return размер кэша.
     */
    public int getSize() {
        return storage.size();
    }

    /**
     * Метод для получения модели по идентификатору.
     * @param key идентификатор.
     * @return модель.
     */
    public Model getModel(Integer key) {
        return storage.get(key);
    }
}
