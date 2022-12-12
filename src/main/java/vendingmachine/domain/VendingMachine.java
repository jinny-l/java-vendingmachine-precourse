package vendingmachine.domain;

import java.util.EnumMap;
import vendingmachine.constant.Coin;
import vendingmachine.constant.message.ErrorMessage;
import vendingmachine.util.CoinRandomGenerator;

public class VendingMachine {

    private static final String COUNT_UNIT = "개";
    private static final String FILED_DELIMITER = " - ";

    private final CoinRandomGenerator coinRandomGenerator;
    private final EnumMap<Coin, Integer> coinsCount = new EnumMap<>(Coin.class);

    public VendingMachine(int money, CoinRandomGenerator coinRandomGenerator) {
        validateMoney(money);
        this.coinRandomGenerator = coinRandomGenerator;
        generateCoins(money);
    }

    private void validateMoney(int money) {
        if (money % Coin.COIN_10.getAmount() != 0 || money < Coin.COIN_10.getAmount()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COINS.toString());
        }
    }

    //TODO: 리팩토링 필요
    private void generateCoins(int money) {
        Coin[] coins = Coin.values();
        Integer[] counts = coinRandomGenerator.generate(money);
        for (int i = 0; i < coins.length; i++) {
            coinsCount.put(coins[i], counts[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        coinsCount.forEach((coin, count) -> stringBuilder.append(coin)
                .append(FILED_DELIMITER)
                .append(count)
                .append(COUNT_UNIT)
                .append("\n")
        );
        return stringBuilder.toString();
    }

}
