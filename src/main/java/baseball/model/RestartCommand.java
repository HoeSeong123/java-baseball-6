package baseball.model;

import static baseball.util.ExceptionMessage.INVALID_RESTART_INPUT;

import java.util.Arrays;
import java.util.function.Predicate;

public enum RestartCommand {
    RESTART("1", true),
    QUIT("2", false);

    private String restartCommand;
    private boolean selectedRetry;

    RestartCommand(String restartCommand, boolean selectedRetry) {
        this.restartCommand = restartCommand;
        this.selectedRetry = selectedRetry;
    }

    public static RestartCommand from(String restartCommand) {
        return Arrays.stream(RestartCommand.values())
                .filter(isSameCommand(restartCommand))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_RESTART_INPUT.message()));
    }

    private static Predicate<RestartCommand> isSameCommand(String restartCommand) {
        return value -> value.restartCommand.equals(restartCommand);
    }

    public boolean isSelectedRetry() {
        return selectedRetry;
    }
}
