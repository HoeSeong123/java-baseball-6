package baseball.controller;

import baseball.model.BaseballNumberGenerator;
import baseball.model.CorrectNumber;
import baseball.model.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballController {
    public void run() {
        OutputView.printGameStartMessage();
        CorrectNumber correctNumber = createCorrectNumber();
        List<Integer> userNumber = InputView.readUserNumber();
    }

    private CorrectNumber createCorrectNumber() {
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator(new RandomNumberGenerator());
        return new CorrectNumber(baseballNumberGenerator.createBaseballNumber());
    }
}
