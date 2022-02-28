package numberbaseballgame;

import java.util.Objects;

public class Ball {

    private int pos;
    private int num;

    public Ball(int pos, int num) {
        this.pos = pos;
        this.num = num;
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (ball.isBall(num)) {
            return BallStatus.BALL;
        }
        return BallStatus.OUT;
    }

    private boolean isBall(int num) {
        return this.num == num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return pos == ball.pos && num == ball.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos, num);
    }
}
