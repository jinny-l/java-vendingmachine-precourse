package vendingmachine.util;

@FunctionalInterface
public interface CoinGenerator {

    void generate(int coins);
}
