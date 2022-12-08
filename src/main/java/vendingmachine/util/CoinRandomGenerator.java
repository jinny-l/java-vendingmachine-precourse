package vendingmachine.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import vendingmachine.constant.Coin;

public class CoinRandomGenerator implements CoinGenerator {

    //TODO: 리팩토링 필요
    public int[] generate(int coins) {
        List<Integer> coinsInformation = Coin.getCoinsAmount();
        int[] coinsCount = new int[Coin.values().length];
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
