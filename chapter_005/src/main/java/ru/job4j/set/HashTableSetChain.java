package ru.job4j.set;


import ru.job4j.list.LinkedArray;

/**
 * Класс для описания множества на основе хэш-таблицы
 * c решением коллизий методом цепочек.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 * @param <E> тип хранимых в контейнере объектов.
 */
public class HashTableSetChain<E> {

    /**
     * Поле для структуры данных.
     */
    private SimpleLinkedSet<E>[] container;

    /**
     * Количество добавленных элементов.
     */
    private int counter = 0;

    /**
     * Конструктор класса.
     * @param size размер контейнера.
     */
    public HashTableSetChain(int size) {
        this.container = new SimpleLinkedSet[size];
        for (int i = 0; i < container.length; i++) {
            container[i] = new SimpleLinkedSet<>();
        }
    }

    /**
     * Конструктор класса.
     */
    public HashTableSetChain() {
        this(10);
    }

    /**
     * Метод для добавления элемента.
     * @param e значение элемента.
     * @return добавился ли элемент.
     */
    public boolean add(E e) {
        boolean isPossible = false;
        if (counter >= container.length * 0.75) {
            this.increaseArray();
        }
        if (!contains(e)) {
            container[this.getHash(e)].add(e);
            counter++;
            isPossible = true;
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
        if (container[hash].getFirst() != null) {
            LinkedArray.Node node = container[hash].getFirst();
            while (node != null) {
                if (e.equals(node.getData())) {
                    arrayContainsE = true;
                    break;
                }
                node = node.getNext();
            }
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
        if (container[hash].getFirst() != null) {
            LinkedArray.Node node = container[hash].getFirst();
            while (node != null) {
                if (e.equals(node.getData())) {
                    container[hash].remove(e);
                    counter--;
                    isRemoved = true;
                    break;
                }
                node = node.getNext();
            }
        }
        return isRemoved;
    }

    /**
     * Метод для увеличения размера массива.
     */
    public void increaseArray() {
        SimpleLinkedSet<E>[] newArray = new SimpleLinkedSet[container.length * 2];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = new SimpleLinkedSet<>();
        }
        for (int i = 0; i < container.length; i++) {
            if (container[i].getFirst() != null) {
                LinkedArray.Node node = container[i].getFirst();
                while (node != null) {
                    int newHash = node.getData().hashCode() % newArray.length;
                    newArray[newHash].add((E) node.getData());
                    node = node.getNext();
                }
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
