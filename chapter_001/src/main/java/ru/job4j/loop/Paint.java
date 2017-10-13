package ru.job4j.loop;

/**
 * Класс Paint для построения пирамиды.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Paint {

    /**
     * Метод piramid для рисования пирамиды заданной высоты.
     * @param height высота пирамиды.
     * @return строка, при выводе которой на экран получается пирамида.
     */
    public String piramid(int height) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i - 1; j++) {
                sBuilder.append(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                sBuilder.append("^");
            }
            sBuilder.append("\n");
        }
        return sBuilder.toString();
    }
}
