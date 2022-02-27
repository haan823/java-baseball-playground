import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballGameTest {

    NumberBaseballGame numberBaseballGame;

    @BeforeEach
    void beforeEach() {
        numberBaseballGame = new NumberBaseballGame();
    }

    @ParameterizedTest
    @CsvSource({"3, true", "2, false"})
    void endGame(int strike, boolean expected) {
        boolean actual = numberBaseballGame.endGame(strike);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"123, 123, 3", "987, 684, 1"})
    void countStrike(String answer, String input, int expected) {
        int actual = numberBaseballGame.countStrike(answer, input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 1", "2, 2, 1", "2, 3, 0"})
    void countCharForStrike(Character answer, Character input, int expected) {
        int actual = numberBaseballGame.countCharForStrike(answer, input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"123, 123, 0", "123, 132, 2", "123, 321, 2"})
    void countBall(String answer, String input, int expected) {
        numberBaseballGame.setAnswer(answer);
        numberBaseballGame.init();
        int actual = numberBaseballGame.countBall(answer, input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("문자가 정답에 포함돼있으면 1, 아니면 0")
    @CsvSource({"100, 0, 1", "123, 4, 0"})
    void countCharForBall(String answer, Character input, int expected) {
        numberBaseballGame.setAnswer(answer);
        numberBaseballGame.init();
        int actual = numberBaseballGame.countCharForBall(input);
        assertEquals(expected, actual);
    }

    @Test
    void play() {
        // 어떻게 테스트하지???
    }

    @Test
    void init() {
        numberBaseballGame.setAnswer("123");
        numberBaseballGame.init();
        int[] count = {0, 1, 1, 1, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 10; i++) {
            assertEquals(count[i], numberBaseballGame.getCount()[i]);
        }
    }

    @Test
    void makeRandomNumber() {
        numberBaseballGame.makeRandomNumber();
        assertThat(numberBaseballGame.getAnswer()).isBetween("000", "999");
    }
}