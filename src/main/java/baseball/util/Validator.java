package baseball.util;

import static baseball.util.ExceptionMessage.INVALID_USER_NUMBER;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Validator {
    public static void validateUserNumber(String input) {
        validateIsNumeric(input);
        validateHasDuplicateNumber(input);
        validateIsThreeDigit(input);
        validateIsInRange(input);
    }

    private static void validateIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit) || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_USER_NUMBER.message());
        }
    }

    private static void validateHasDuplicateNumber(String input) {
        String[] numberSplit = input.split("");

        if (numberSplit.length != Arrays.stream(numberSplit).distinct().count()) {
            throw new IllegalArgumentException(INVALID_USER_NUMBER.message());
        }
    }

    private static void validateIsThreeDigit(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(INVALID_USER_NUMBER.message());
        }
    }

    private static void validateIsInRange(String input) {
        if (!Pattern.matches("^[1-9]*$", input)) {
            throw new IllegalArgumentException(INVALID_USER_NUMBER.message());
        }
    }

}
