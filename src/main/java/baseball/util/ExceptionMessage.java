package baseball.util;

public enum ExceptionMessage {

    INVALID_USER_NUMBER("1 ~ 9 사이의 숫자만 입력하여야 합니다."),
    INVALID_RESTART_INPUT("1 또는 2를 입력해야 합니다."),
    INVALID_GAME_STATUS("해당하는 게임 상태가 없습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String message() {
        return message;
    }
}
