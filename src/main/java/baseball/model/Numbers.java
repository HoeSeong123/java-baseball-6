package baseball.model;

import java.util.List;

public class Numbers {
    private List<Integer> correctNumbers;

    public Numbers(List<Integer> numbers) {
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
