package baseball.controller;

import baseball.model.BaseballNumberGenerator;
import baseball.model.CorrectNumber;
import baseball.model.GameResult;
import baseball.model.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;
import java.util.function.Supplier;

public class BaseballController {
    public void run() {
        OutputView.printGameStartMessage();
        do {
            playOneGame();
        } while (checkRestart());
    }

    private void playOneGame() {
        boolean isOver = false;
        CorrectNumber correctNumber = createCorrectNumber();

        while (!isOver) {
            List<Integer> userNumbers = readUserNumber();
            GameResult gameResult = correctNumber.checkNumber(userNumbers);
            OutputView.printResult(gameResult);
            isOver = gameResult.isOver();
        }

        OutputView.printGameOverMessage();
    }

    private CorrectNumber createCorrectNumber() {
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator(new RandomNumberGenerator());
        return new CorrectNumber(baseballNumberGenerator.createBaseballNumber());
    }

    private List<Integer> readUserNumber() {
        return readWithRetry(InputView::readUserNumber);
    }

    private boolean checkRestart() {
        int restartInput = InputView.readRestartInput();

        if (restartInput == 2) {
            return false;
        }

        return true;
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
