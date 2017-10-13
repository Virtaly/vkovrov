package ru.job4j.loop;

/**
 * Class Board для построения шахматной доски.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class Board {

    /**
     * Метод paint создает символьную строку, при выводе которой получится шахматная доска.
     * @param width ширина шахматной доски.
     * @param height высота шахматной доски.
     * @return строка, при выводе которой получится шахматная доска.
     */
    public String paint(int width, int height) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i % 2 == j % 2) {
                    string.append("X");
                } else {
                    string.append(" ");
                }
            }
            string.append("\n");
        }
        return string.toString();
    }
}
