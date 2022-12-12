package vendingmachine.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import vendingmachine.constant.Coin;

public class CoinRandomGenerator {

    public Integer[] generate(int coins) {
        List<Integer> coinsInformation = Coin.getAllAmounts();
        Integer[] coinsCount = new Integer[Coin.values().length];
        Arrays.fill(coinsCount, 0);
        while (coins > 0) {
            int coin = Randoms.pickNumberInList(coinsInformation);
            if (coin > coins) {
                continue;
            }
            for (int i = 0; i < Coin.values().length; i++) {
                if (coin == Coin.values()[i].getAmount()) {
                    coinsCount[i]++;
                }
            }
            coins -= coin;
        }
        return coinsCount;
    }

}
