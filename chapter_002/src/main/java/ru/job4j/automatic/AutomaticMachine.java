package ru.job4j.automatic;

/**
 * Класс для описания автомата по выдаче сдачи.
 * @author vkovrov
 * @version 0.1
 * @since 0.1
 */
public class AutomaticMachine {

    /**
     * Массив содержащий количество монет каждого номинала (10, 5, 2, 1).
     */
    private int[] coinsArr;

    /**
     * Метод для подсчета количества монет каждого номинала, которыми нужно дать сдачу.
     * @param cash наличные за товар.
     * @param price цена товара.
     * @return массив содержащий количество монет каждого номинала (10, 5, 2, 1)
     */
    public int[] getCoins(int cash, int price) {
        coinsArr = new int[4];
        int oddMoney = cash - price;
        if (oddMoney < 0) {
            throw new NotEnoughMoneyException();
        }
        this.countCoins(oddMoney, 10, 0);
        return coinsArr;
    }

    /**
     * Метод для составления массива монет, которыми нужно дать сдачу.
     * @param oddMoney сдача.
     * @param coinNominal номинал монеты.
     * @param position позиция индекса в массиве номиналов монет.
     */
    private void countCoins(int oddMoney, int coinNominal, int position) {
        if (coinNominal > 1) {
            if (oddMoney >= coinNominal) {
                this.coinsArr[position] = oddMoney / coinNominal;
                oddMoney %= coinNominal;
            }
            countCoins(oddMoney, coinNominal / 2, ++position);

        }

    }
}
