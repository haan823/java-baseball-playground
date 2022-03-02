package numberbaseballgame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    private Balls balls;

    @BeforeEach
    void setUp() {
        balls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void strike() {
        BallStatus ballStatus = balls.play(new Ball(1, 1));
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        BallStatus ballStatus = balls.play(new Ball(1, 2));
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void out() {
        BallStatus ballStatus = balls.play(new Ball(1, 4));
        assertThat(ballStatus).isEqualTo(BallStatus.OUT);
    }

    @Test
    @DisplayName("3스트라이크")
    void test() {
        PlayResult result = balls.play(Arrays.asList(1, 2, 3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("3볼")
    void test2() {
        PlayResult result = balls.play(Arrays.asList(2, 3, 1));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("아웃")
    void test3() {
        PlayResult result = balls.play(Arrays.asList(6, 5, 4));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("1스트라이크 1볼")
    void test4() {
        PlayResult result = balls.play(Arrays.asList(1, 3, 5));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }
}
