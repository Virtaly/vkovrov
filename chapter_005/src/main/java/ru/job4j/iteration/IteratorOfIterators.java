package ru.job4j.iteration;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс для преобразования итератора итераторов целых чисел в итератор целых чисел.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class IteratorOfIterators {

    /**
     * Метод для преобразования итератора итераторов целых чисел в итератор целых чисел.
     * @param it итератор итераторов целых чисел.
     * @return итератор целых чисел.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            /**
             * Поле для итератора итераторов.
             */
            private Iterator<Iterator<Integer>> aIt = it;

            /**
             * Поле для указателя на текущий элемент в итераторе итераторов.
             */
            private Iterator<Integer> currentIterator = aIt.next();

            /**
             * Метод для определения наличия следующего элемента.
             * @return есть ли следующий элемент.
             */
            @Override
            public boolean hasNext() {
                return currentIterator.hasNext() || aIt.next().hasNext();
            }

            /**
             * Метод для возвращения следующего элемента.
             * @return следующий элемент.
             */
            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return currentIterator.next();
            }
        };
    }
}
