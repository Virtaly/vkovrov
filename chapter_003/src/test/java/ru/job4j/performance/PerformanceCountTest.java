package ru.job4j.performance;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;



/**
 * Тест для класса Item.
 * @author Vitaly Kovrov (mailto:virtaly@ya.ru)
 * @version 0.1
 * @since 0.1
 */

public class PerformanceCountTest {

    /**
     * Тест для метода add.
     * Должно быть выведено время, затраченное на добавление элементов в коллецию.
     */
    @Test
    public void whenAddHundredElementsThenCountElapsedTime() {
        PerformanceCount counter = new PerformanceCount();
        List<String> linked = new LinkedList<>();
        System.out.println(String.format("Speed of linkedlist add: %d millis", counter.add(linked, 10000)));
        List<String> array = new ArrayList<>();
        System.out.println(String.format("Speed of arraylist add: %d millis", counter.add(array, 10000)));
        Set<String> set = new TreeSet<>();
        System.out.println(String.format("Speed of treeset add: %d millis", counter.add(set, 10000)));


    }

    /**
     * Тест для метода delete.
     * Должно быть выведено время, затраченное на удаление элементов из коллеции.
     */
    @Test
    public void whenDeleteNineteenElementsThenCountElapsedTime() {
        PerformanceCount counter = new PerformanceCount();
        List<String> linked = new LinkedList<>();
        counter.add(linked, 10000);
        System.out.println(String.format("Speed of linkedlist delete: %d millis", counter.delete(linked, 9990)));
        List<String> array = new ArrayList<>();
        counter.add(array, 10000);
        System.out.println(String.format("Speed of arraylist delete: %d millis", counter.delete(array, 9990)));
        Set<String> set = new TreeSet<>();
        counter.add(set, 10000);
        System.out.println(String.format("Speed of treeset delete: %d millis", counter.delete(set, 9990)));


    }

}