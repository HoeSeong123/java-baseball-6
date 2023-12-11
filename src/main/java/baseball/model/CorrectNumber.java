package baseball.model;

import java.util.List;

public class CorrectNumber {
    private List<Integer> correctNumbers;

    public CorrectNumber(List<Integer> numbers) {
        correctNumbers = numbers;
    }

    public GameResult checkNumber(List<Integer> userNumbers) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < userNumbers.size(); i++) {
            int number = userNumbers.get(i);
            if (correctNumbers.contains(number)) {
                if (correctNumbers.indexOf(number) == i) {
                    strikeCount++;
                    continue;
                }
                ballCount++;
            }
        }

        return new GameResult(strikeCount, ballCount);
    }

}
