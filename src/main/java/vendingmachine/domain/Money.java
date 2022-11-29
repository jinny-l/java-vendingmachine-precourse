package vendingmachine.domain;

import java.util.List;
import vendingmachine.information.ErrorMessage;

public class Money {

    private static int MIN_MONEY = 10;

    private int money;

    public Money(int money) {
        validateMinMoney(money);
        validateMoneyUnit(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void decreaseMoney(List<Integer> money) {
        this.money -= money.get(0);
    }

    private void validateMinMoney(int money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.getMessage());
        }
    }

    private void validateMoneyUnit(int money) {
        if (money % MIN_MONEY != 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.getMessage());
        }
    }

}
