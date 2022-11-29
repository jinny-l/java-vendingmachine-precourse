package vendingmachine.information;

public enum ErrorMessage {

    INPUT_ERROR("정확하게 입력해 주세요.");

    private static final String ERROR = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }

}
