package baseball.model;

public class GameResult {
    private int strikeCount;
    private int ballCount;

    public GameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public String getResult() {
        if (strikeCount != 0 && ballCount == 0) {
            return strikeCount + "스트라이크";
        }
        if (strikeCount == 0 && ballCount != 0) {
            return ballCount + "볼";
        }
        if (strikeCount != 0 && ballCount != 0) {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        }
        return "낫싱";
    }
}
