package baseball.view;

import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static List<Integer> readUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        Validator.validateUserNumber(input);
        return input.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }
}
