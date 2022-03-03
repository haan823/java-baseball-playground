package numberbaseballgame;

public class NumberBaseballGame {
    public static void main(String[] args) {
        do {
            play();
        } while (InputView.replay());
    }

    private static void play() {
        Balls balls = new Balls(RandomNumberGenerator.generateRandomNumber());
        PlayResult playResult;
        do {
            playResult = balls.play(InputView.input());
            ResultView.output(playResult);
        } while (playResult.getStrike() != 3);
    }
}
