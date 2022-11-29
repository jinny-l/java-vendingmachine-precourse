package vendingmachine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Coin {
    COIN_500(500, 0),
    COIN_100(100, 0),
    COIN_50(50, 0),
    COIN_10(10, 0);

    private static final String COIN_UNIT = "원";
    private static final String INFO_DELIMITER = " - ";
    private static final String COUNT_UNIT = "개";

    private final int amount;
    private int count;

    Coin(final int amount, int count) {
        this.amount = amount;
        this.count = count;
    }

    public static String getCoinUnit() {
        return COIN_UNIT;
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

    public static String getCoinsInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Coin.values().length; i++) {
            stringBuilder.append(Coin.values()[i].getAmount())
                    .append(COIN_UNIT)
                    .append(INFO_DELIMITER)
                    .append(Coin.values()[i].getCount())
                    .append(COUNT_UNIT)
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    // TODO: 잔돈을 출력하는 기능 구현
//    private String payCoin(int changes, int ordinal) {
//        int coinSum = getCoinSum();
//        int count;
//        this.count = changes / Coin.values()[i].getAmount()
//        }
//
//    }

    private int getCoinSum() {
        int sum = 0;
        for (int i = 0; i < Coin.values().length; i++) {
            sum += Coin.values()[i].getAmount() * Coin.values()[i].getCount();
        }
        return sum;
    }


    public void increaseCount() {
        count++;
    }

    public void decreaseCount() {
        count--;
    }

}
