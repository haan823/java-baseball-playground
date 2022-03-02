package numberbaseballgame;

public enum BallStatus {
    STRIKE, BALL, OUT;

    public boolean isNotOut() {
        return this != OUT;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
