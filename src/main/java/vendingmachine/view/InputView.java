package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.message.ErrorMessage;
import vendingmachine.constant.message.SystemMessage;

public class InputView {

    public static int readMoney() {
        System.out.println(SystemMessage.INPUT_COINS);
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COINS_INPUT_TYPE.toString());
        }
    }

    public static String readProducts() {
        System.out.println(SystemMessage.INPUT_PRODUCTS);
        return readLine();
    }

    private static String readLine() {
        String input = Console.readLine().trim();
        validateHasInput(input);
        return input;
    }

    private static void validateHasInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.toString());
        }
    }

}
