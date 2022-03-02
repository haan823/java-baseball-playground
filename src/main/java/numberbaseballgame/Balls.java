package numberbaseballgame;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> answers;

    public Balls(List<Integer> integers) {
        List<Ball> balls = getBalls(integers);
        this.answers = balls;
    }

    private List<Ball> getBalls(List<Integer> integers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, integers.get(i)));
        }
        return balls;
    }

    public BallStatus play(Ball ball) {
        return answers.stream()
                .map(answer -> answer.play(ball))
                .filter(status -> status != BallStatus.OUT)
                .findFirst()
                .orElse(BallStatus.OUT);
    }
}
