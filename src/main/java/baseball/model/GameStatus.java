package baseball.model;

import static baseball.util.ExceptionMessage.INVALID_GAME_STATUS;

public enum GameStatus {
    GAME_START,
    GAME_PLAYING,
    GAME_OVER,
    GAME_RETRY,
    APPLICATION_EXIT;

    public static GameStatus fromIsThreeStrike(boolean isThreeStrike) {
        if (isThreeStrike) {
            return GAME_OVER;
        }
        if (!isThreeStrike) {
            return GAME_PLAYING;
        }
        throw new IllegalArgumentException(INVALID_GAME_STATUS.message());
    }

    public static GameStatus fromSelectedRetry(boolean isSelectedRetry) {
        if (isSelectedRetry) {
            return GAME_RETRY;
        }
        if (!isSelectedRetry) {
            return APPLICATION_EXIT;
        }
        throw new IllegalArgumentException(INVALID_GAME_STATUS.message());
    }

    public static boolean isGameOver(GameStatus gameStatus) {
        return GAME_OVER == gameStatus;
    }

    public static boolean isApplicationExit(GameStatus gameStatus) {
        return APPLICATION_EXIT == gameStatus;
    }
}
