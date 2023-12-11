package baseball.controller;

import baseball.model.BaseballNumberGenerator;
import baseball.model.GameResult;
import baseball.model.GameStatus;
import baseball.model.Numbers;
import baseball.model.RandomNumberGenerator;
import baseball.model.RestartCommand;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;
import java.util.function.Supplier;

public class BaseballController {
    private GameStatus gameStatus;

    public BaseballController() {
        gameStatus = GameStatus.GAME_START;
    }

    public void run() {
        OutputView.printGameStartMessage();
        do {
            playOneGame();
            gameStatus = GameStatus.fromSelectedRetry(isSelectedRetry());
        } while (!GameStatus.isApplicationExit(gameStatus));
    }

    private void playOneGame() {
        Numbers correctNumber = createCorrectNumber();

        while (!GameStatus.isGameOver(gameStatus)) {
            List<Integer> userNumbers = readUserNumber();
            GameResult gameResult = correctNumber.checkNumber(userNumbers);
            OutputView.printResult(gameResult);
            gameStatus = GameStatus.fromIsThreeStrike(gameResult.isThreeStrike());
        }

        OutputView.printGameOverMessage();
    }

    private Numbers createCorrectNumber() {
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator(new RandomNumberGenerator());
        return new Numbers(baseballNumberGenerator.createBaseballNumber());
    }

    private List<Integer> readUserNumber() {
        return readWithRetry(InputView::readUserNumber);
    }

    private boolean isSelectedRetry() {
        return RestartCommand.from(InputView.readRestartInput()).isSelectedRetry();
    }

    private <T> T readWithRetry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMessage(e.getMessage());
            }
        }
    }
}
