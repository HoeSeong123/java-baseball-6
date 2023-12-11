package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
