package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс для описания пары ключ/значение.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <K> тип ключа.
 * @param <V> тип значения.
 */
public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Couple> {

    /**
     * Поле для структуры данных.
     */
    private Couple<K, V>[] container;

    /**
     * Количество добавленных элементов.
     */
    private int counter = 0;

    /**
     * Конструктор класса.
     * @param size размер контейнера.
     */
    public SimpleHashMap(int size) {
        container = new Couple[size];
    }

    /**
     * Конструктор класса.
     */
    public SimpleHashMap() {
        this(10);
    }

    /**
     * Метод для добавления элемента.
     * @param key ключ элемента.
     * @param value значение элемента.
     * @return добавился ли элемент.
     */
    public boolean insert(K key, V value) {
        boolean isPossible = true;
        if (counter >= container.length * 0.75) {
            this.increaseArray();
        }
        int hash = this.getHash(key);
        while (container[hash] != null) {
            if (!key.equals(container[hash].getKey())) {
                hash++;
                hash %= container.length;
            } else {
                isPossible = false;
                break;
            }
        }
        if (isPossible) {
            container[hash] = new Couple<>(key, value);
            counter++;
        }
        return isPossible;
    }

    /**
     * Метод для получения элемента из контейнера.
     * @param key ключ элемента.
     * @return значение элемента.
     */
    public V get(K key) {
        V value = null;
        int hash = this.getHash(key);
        while (container[hash] != null) {
            if (key.equals(container[hash].getKey())) {
                value = container[hash].getValue();
                break;
            }
            hash++;
            hash %= container.length;
        }
        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }

    /**
     * Метод для удаления элемента.
     * @param key ключ элемента.
     * @return удалился ли элемент.
     */
    public boolean delete(K key) {
        boolean isRemoved = false;
        int hash = this.getHash(key);
        while (container[hash] != null) {
            if (key.equals(container[hash].getKey())) {
                container[hash] = null;
                counter--;
                isRemoved = true;
                break;
            }
            hash++;
            hash %= container.length;
        }
        return isRemoved;
    }

    /**
     * Метод для увеличения размера массива.
     */
    public void increaseArray() {
        Couple<K, V>[] newArray = new Couple[container.length * 2];
        for (int i = 0; i < container.length; i++) {
            if (container[i] != null) {
                int newHash = container[i].getKey().hashCode() % newArray.length;
                while (newArray[newHash] != null) {
                    newHash++;
                    newHash %= newArray.length;
                }
                newArray[newHash] = container[i];
            }
        }
        container = newArray;
    }

    /**
     * Метод для генерации хеш-кода.
     * @param key ключ.
     * @return хеш-код ключа.
     */
    public int getHash(K key) {
        return key.hashCode() % container.length;
    }

    /**
     * Метод для получения итератора структуры данных.
     * @return итератор.
     */
    @Override
    public Iterator<Couple> iterator() {
        return new Iterator<Couple>() {

            /**
             * Указатель на текущий элемент.
             */
            private int pointer = 0;

            /**
             * Метод для определения наличия следующего элемента в контейнере.
             * @return есть ли следующий элемент в контейнере.
             */
            @Override
            public boolean hasNext() {
                return find(pointer) != null;
            }

            /**
             * Метод для возвращения следующего элемента контейнера.
             * @return следующий элемент контейнера.
             */
            @Override
            public Couple next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Couple nextCouple = find(pointer);
                pointer++;
                return nextCouple;
            }

            /**
             * Метод для поиска следующего элемента.
             * @param current индекс начала поиска.
             * @return следующий объект в контейнере.
             */
            private Couple find(int current) {
                Couple nextCouple = null;
                while (current < container.length) {
                    if (container[current] != null) {
                        nextCouple = container[current];
                        break;
                    }
                    current++;
                }
                pointer = current;
                return nextCouple;
            }
        };
    }

    /**
     * Класс для описания пары ключ/значение.
     * @author vkovrov
     * @version 0.1
     * @since 0.1
     * @param <K> тип ключа.
     * @param <V> тип значения.
     */
    public class Couple<K, V> {

        /**
         * Поле для ключа.
         */
        private K key;

        /**
         * Поле для значения.
         */
        private V value;

        /**
         * Конструктор класса.
         * @param key ключ.
         * @param value значение.
         */
        Couple(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Геттер для ключа.
         * @return ключ.
         */
        public K getKey() {
            return key;
        }

        /**
         * Геттер для значения.
         * @return значение.
         */
        public V getValue() {
            return value;
        }
    }

}
