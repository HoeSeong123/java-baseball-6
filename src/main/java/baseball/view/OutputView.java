package baseball.view;

import baseball.model.GameResult;

public class OutputView {
    public static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }


    public static void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public static void printResult(GameResult gameResult) {
        System.out.println(gameResult.getResult());
    }

    public static void printGameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
