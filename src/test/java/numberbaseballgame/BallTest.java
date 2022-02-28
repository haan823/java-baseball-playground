package numberbaseballgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1, 4);
    }

    @Test
    void strike() {
        BallStatus ballStatus = com.play(new Ball(1, 4));
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        BallStatus ballStatus = com.play(new Ball(2, 4));
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void out() {
        BallStatus ballStatus = com.play(new Ball(1, 3));
        assertThat(ballStatus).isEqualTo(BallStatus.OUT);
    }
}
