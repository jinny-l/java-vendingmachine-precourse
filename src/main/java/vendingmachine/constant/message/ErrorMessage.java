package vendingmachine.constant.message;

public enum ErrorMessage {

    EMPTY_INPUT("입력 값이 없습니다."),
    INVALID_COINS_INPUT_TYPE("숫자만 입력 가능합니다.");

    private static final String ERROR = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR + message;
    }

}
