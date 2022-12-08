package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import vendingmachine.constant.Coin;
import vendingmachine.constant.ErrorMessage;
import vendingmachine.util.CoinGenerator;

public class VendingMachine {

    private static final String COUNT_UNIT = "개";
    private static final String FILED_DELIMITER = " - ";

    private final List<Integer> coinsCount;

    public VendingMachine(int coins, CoinGenerator coinGenerator) {
        validateCoins(coins);
        coinsCount = Arrays.asList(coinGenerator.generate(coins));
    }

    private void validateCoins(int coins) {
        if (coins % Coin.MIN_COIN.getAmount() != 0 || coins < Coin.COIN_10.getAmount()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COINS.toString());
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < coinsCount.size(); i++) {
            stringBuilder.append(Coin.values()[i].toString())
                    .append(FILED_DELIMITER)
                    .append(coinsCount.get(i) + COUNT_UNIT)
                    .append("\n");
        }
        return stringBuilder.toString();
    }

}
