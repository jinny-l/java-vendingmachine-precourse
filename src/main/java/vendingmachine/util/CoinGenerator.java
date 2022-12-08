package vendingmachine.util;

@FunctionalInterface
public interface CoinGenerator {

    Integer[] generate(int coins);
}
