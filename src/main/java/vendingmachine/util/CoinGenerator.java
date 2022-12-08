package vendingmachine.util;

@FunctionalInterface
public interface CoinGenerator {

    int[] generate(int coins);
}
