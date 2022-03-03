package numberbaseballgame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("랜덤 숫자는 세 개")
    void generateRandomNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> integers = randomNumberGenerator.generateRandomNumber();
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        Assertions.assertThat(integers.size()).isEqualTo(3);
    }
}