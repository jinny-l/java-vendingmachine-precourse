package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_COINS = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_PRODUCTS = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_MONEY = "투입 금액을 입력해 주세요.";
    private static final String INPUT_PRODUCT = "구매할 상품명을 입력해 주세요.";

    public static int readCoins() {
        System.out.println(INPUT_COINS);
        String input = input();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException();
        }
    }

    public static String readProducts() {
        System.out.println(INPUT_PRODUCTS);
        String input = input();
        return input;
    }

    public static int readMoney() {
        System.out.println(INPUT_MONEY);
        String input = input();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException();
        }
    }

    public static String readProduct() {
        System.out.println(INPUT_PRODUCT);
        return input();
    }

    private static String input() {
        String input = Console.readLine().trim();
        validateHasInput(input);
        return input;
    }

    private static void validateHasInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

}
