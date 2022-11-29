package vendingmachine.domain;

import java.util.List;

public class Money {

    int money;

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void decreaseMoney(List<Integer> money) {
        this.money -= money.get(0);
    }

}
