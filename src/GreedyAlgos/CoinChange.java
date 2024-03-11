package GreedyAlgos;

import java.util.Arrays;

public class CoinChange {
    public static void coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int index = coins.length - 1;

        while (true) {
            int coinValue = coins[index];
            index--;
            int maxAmount = (amount / coinValue) * coinValue;

            if (maxAmount > 0) {
                System.out.println("Coin value: " + coinValue + " taken count: " + (amount / coinValue));
                amount -= maxAmount;
            }

            if (amount == 0) break;
        }
    }
}
