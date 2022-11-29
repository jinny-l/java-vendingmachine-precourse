package vendingmachine.view;

public class OutputView {

    private static final String OUTPUT_VENDING_MACHINE_COINS = "자판기가 보유한 동전";
    private static final String OUTPUT_CHANGES = "투입 금액: %s%n";
    private static final String OUTPUT_RESULT = "잔돈%n%s%n";

    public static void printVendingMachineCoins(String coinsInfo) {
        System.out.println(OUTPUT_VENDING_MACHINE_COINS);
        System.out.println(coinsInfo);
    }

    public static void printChanges(int changes) {
        System.out.printf(OUTPUT_CHANGES, changes);
    }

    public static void printResult(String coinsResult) {
        System.out.printf(OUTPUT_RESULT, coinsResult);
    }

}
