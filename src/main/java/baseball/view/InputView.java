package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static List<Integer> readUserNumber() {
        String input = Console.readLine();

        return input.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }
}
