package numberbaseballgame;

public enum BallStatus {
    STRIKE, BALL, OUT;

    public boolean isNotOut() {
        return this != OUT;
    }
}
