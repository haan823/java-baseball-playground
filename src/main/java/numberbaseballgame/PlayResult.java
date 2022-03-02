package numberbaseballgame;

public class PlayResult {

    private int strike;
    private int ball;


    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void report(BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            this.strike++;
        }
        if (ballStatus.isBall()) {
            this.ball++;
        }
    }
}
