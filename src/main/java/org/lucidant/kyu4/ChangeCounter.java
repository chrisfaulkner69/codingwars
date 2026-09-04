package org.lucidant.kyu4;

import java.util.Arrays;
import java.util.List;

public class ChangeCounter {

    public static int countChange(final int money, final int[] coins) {
        int[] waysToReachTotal = new int[money + 1];
        waysToReachTotal[0] = 1;
        List<Integer> denominations = Arrays.stream(coins)
                .boxed()
                .toList();

        for (int thisCoin : denominations) {
            for (int currentTotal = thisCoin; currentTotal <= money; currentTotal++) {
                waysToReachTotal[currentTotal] =
                        (waysToReachTotal[currentTotal] + waysToReachTotal[currentTotal - thisCoin]);
            }
        }

        return waysToReachTotal[money];
    }
}
