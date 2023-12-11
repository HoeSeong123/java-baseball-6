package baseball.util;

public enum ExceptionMessage {

    INVALID_USER_NUMBER("1 ~ 9 사이의 숫자만 입력하여야 합니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String message() {
        return message;
    }
}
