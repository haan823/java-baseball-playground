package numberbaseballgame;

import java.util.Objects;

public class BallNumber {

    private final static int MIN_NUM = 0;
    private final static int MAX_NUM = 9;

    private int num;

    public BallNumber(int num) {
        if (num < MIN_NUM || num > MAX_NUM) {
            throw new IllegalArgumentException("볼 숫자는 0 이상 9 이하의 정수 합니다.");
        }
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return num == that.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
