package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumberGenerator {
    private final NumberGenerator numberGenerator;

    public BaseballNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Integer> createBaseballNumber() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int randomNumber = numberGenerator.generateNumber();
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }
}
