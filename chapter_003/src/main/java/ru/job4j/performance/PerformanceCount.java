package ru.job4j.performance;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/**
 * Класс для тестирования производительности коллекций.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class PerformanceCount {

    /**
     * Метод для подсчета времени, затраченного на добавление в коллекцию рандомных строк.
     * @param collection коллекция.
     * @param amount количество рандомных строк.
     * @return затраченное время в миллисекундах.
     */
    public long add(Collection<String> collection, int amount) {
        StringBuilder builder;
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            builder = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                builder.append((char) Integer.parseInt(Integer.toHexString(random.nextInt(65536)), 16));
            }
            collection.add(builder.toString());
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        return elapsedTime;
    }

    /**
     * Метод для подсчета времени, затраченного на удаление из коллекции первых элементов.
     * @param collection коллекция.
     * @param amount количество первых элементов.
     * @return затраченное времени в миллисекундах.
     */
    public long delete(Collection<String> collection, int amount) {
        Iterator<String> iterator = collection.iterator();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            } else {
                break;
            }
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        return elapsedTime;
    }
}
