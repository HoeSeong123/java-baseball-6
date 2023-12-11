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
        while (true) {
            CorrectNumber correctNumber = createCorrectNumber();
            while (true) {
                List<Integer> userNumbers = readUserNumber();
                GameResult gameResult = correctNumber.checkNumber(userNumbers);
                OutputView.printResult(gameResult);

                if (gameResult.isOver()) {
                    break;
                }
            }
            OutputView.printGameOverMessage();
            int restartInput = InputView.readRestartInput();

            if (restartInput == 2) {
                break;
            }
        }
    }

    private CorrectNumber createCorrectNumber() {
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator(new RandomNumberGenerator());
        return new CorrectNumber(baseballNumberGenerator.createBaseballNumber());
    }

    private List<Integer> readUserNumber() {
        return readWithRetry(InputView::readUserNumber);
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
