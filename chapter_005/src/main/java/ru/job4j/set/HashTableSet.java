package ru.job4j.set;

/**
 * Класс для описания множества на основе хэш-таблицы
 * с решением коллизий методом линейного пробирования.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <E> тип хранимых в контейнере объектов.
 */
public class HashTableSet<E> {

    /**
     * Поле для структуры данных.
     */
    private E[] container;

    /**
     * Количество добавленных элементов.
     */
    private int counter = 0;

    /**
     * Конструктор класса.
     * @param size размер контейнера.
     */
    public HashTableSet(int size) {
        this.container = (E[]) new Object[size];
    }

    /**
     * Конструктор класса.
     */
    public HashTableSet() {
        this(10);
    }

    /**
     * Метод для добавления элемента.
     * @param e значение элемента.
     * @return добавился ли элемент.
     */
    public boolean add(E e) {
        boolean isPossible = true;
        if (counter >= container.length * 0.75) {
            this.increaseArray();
        }
        int hash = this.getHash(e);
        while (container[hash] != null) {
            if (!e.equals(container[hash])) {
                hash++;
                hash %= container.length;
            } else {
                isPossible = false;
                break;
            }
        }
        if (isPossible) {
            container[hash] = e;
            counter++;
        }
        return isPossible;
    }

    /**
     * Метод для проверки наличия элемента в контейнере.
     * @param e значение элемента.
     * @return существует ли элемент с таким значением в контейнере.
     */
    public boolean contains(E e) {
        boolean arrayContainsE = false;
        int hash = this.getHash(e);
        while (container[hash] != null) {
            if (e.equals(container[hash])) {
                arrayContainsE = true;
                break;
            }
            hash++;
            hash %= container.length;
        }
        return arrayContainsE;
    }

    /**
     * Метод для удаления элемента.
     * @param e значение элемента.
     * @return удалился ли элемент.
     */
    public boolean remove(E e) {
        boolean isRemoved = false;
        int hash = this.getHash(e);
        while (container[hash] != null) {
            if (e.equals(container[hash])) {
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
        E[] newArray = (E[]) new Object[container.length * 2];
        for (int i = 0; i < container.length; i++) {
            if (container[i] != null) {
                int newHash = container[i].hashCode() % newArray.length;
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
     * @param e объект.
     * @return хеш-код объекта.
     */
    public int getHash(E e) {
        return e.hashCode() % container.length;
    }
}
