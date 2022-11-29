package vendingmachine.domain;

public class Money {

    int money;

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void decreaseMoney(int money) {
        this.money -= money;
    }

}
