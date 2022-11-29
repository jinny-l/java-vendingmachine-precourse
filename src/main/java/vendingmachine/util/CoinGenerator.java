package vendingmachine.util;

import java.util.List;

@FunctionalInterface
public interface CoinGenerator {

    void generate(int coins, List<Integer> coinsInformation);
}
