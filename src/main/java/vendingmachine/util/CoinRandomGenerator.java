package vendingmachine.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import vendingmachine.Coin;

public class CoinRandomGenerator implements CoinGenerator {

    public void generate(int coins) {
        List<Integer> coinsInformation = Coin.getCoinsAmount();
        while (coins > 0) {
            int coin = Randoms.pickNumberInList(coinsInformation);
            for (int i = 0; i < Coin.values().length; i++) {
                if (coin > coins) {
                    continue;
                }
                if (coin == Coin.values()[i].getAmount()) {
                    Coin.values()[i].increaseCount();
                }
            }
            coins -= coin;
        }
    }

}
