package vendingmachine.constant;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Coin {

    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private static final String COIN_UNIT = "원";

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static List<Integer> getAllAmounts() {
        return Stream.of(Coin.values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return amount + COIN_UNIT;
    }

}
