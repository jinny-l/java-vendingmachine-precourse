package vendingmachine.view;

import vendingmachine.domain.VendingMachine;

public class OutputView {

    private static final String OUTPUT_VENDING_MACHINE_COINS = "\n자판기가 보유한 동전";

    public static void printVendingMachine(VendingMachine vendingMachine) {
        System.out.println(OUTPUT_VENDING_MACHINE_COINS);
        System.out.print(vendingMachine.toString());
    }

}
