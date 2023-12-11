package baseball.controller;

import baseball.model.BaseballNumberGenerator;
import baseball.model.CorrectNumber;
import baseball.model.RandomNumberGenerator;
import baseball.view.OutputView;

public class BaseballController {
    public void run() {
        OutputView.printGameStartMessage();
        CorrectNumber correctNumber = createCorrectNumber();
    }

    private CorrectNumber createCorrectNumber() {
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator(new RandomNumberGenerator());
        return new CorrectNumber(baseballNumberGenerator.createBaseballNumber());
    }
}
