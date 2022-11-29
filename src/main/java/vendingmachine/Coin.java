package vendingmachine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Coin {
    COIN_500(500, 0),
    COIN_100(100, 0),
    COIN_50(50, 0),
    COIN_10(10, 0);

    private final int amount;
    private int count;

    Coin(final int amount, int count) {
        this.amount = amount;
        this.count = count;
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }

    public static List<Integer> getCoinsAmount() {
        return Stream.of(Coin.values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());
    }

    public static List<Integer> getCoinsCount() {
        return Stream.of(Coin.values())
                .map(Coin::getCount)
                .collect(Collectors.toList());
    }

    public void increaseCount() {
        count++;
    }

    public void decreaseCount() {
        count--;
    }

}
