package vendingmachine.constant.message;

public enum SystemMessage {

    INPUT_COINS("자판기가 보유하고 있는 금액을 입력해 주세요."),
    INPUT_PRODUCTS("상품명과 가격, 수량을 입력해 주세요."),
    INPUT_MONEY("투입 금액을 입력해 주세요."),
    INPUT_PRODUCT("구매할 상품명을 입력해 주세요."),
    OUTPUT_COINS("자판기가 보유한 동전");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}
