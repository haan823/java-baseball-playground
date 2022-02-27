import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    StringCalculator stringCalculator;
    long actualValue;

    @BeforeEach
    void beforeEach() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("더하기")
    void add() {
        //given
        stringCalculator.setResult(1);

        //when
        actualValue = stringCalculator.add(3);

        //then
        assertThat(actualValue).isEqualTo(4);
    }

    @Test
    @DisplayName("빼기")
    void sub() {
        //given
        stringCalculator.setResult(1);

        //when
        actualValue = stringCalculator.sub(3);

        //then
        assertThat(actualValue).isEqualTo(-2);
    }

    @Test
    @DisplayName("곱하기")
    void mul() {
        //given
        stringCalculator.setResult(1);

        //when
        actualValue = stringCalculator.mul(3);

        //then
        assertThat(actualValue).isEqualTo(3);
    }

    @Test
    @DisplayName("0으로 나누는 경우")
    void div_by_zero() {
        //given
        stringCalculator.setResult(1);

        //when //then
        assertThatThrownBy(() -> {
            actualValue = stringCalculator.div(0);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("0으로 나눌 수 없습니다.");
    }

    @Test
    @DisplayName("나누기")
    void div() {
        //given
        stringCalculator.setResult(10);

        //when
        actualValue = stringCalculator.div(2);

        //then
        assertThat(actualValue).isEqualTo(5);
    }

    @ParameterizedTest
    @DisplayName("피연산자 유효성 검사")
    @CsvSource({"1, true", "123, true", "2a5, false", "24%, false"})
    void checkOperand(String operand, boolean expected) {
        //given //when
        boolean actual = stringCalculator.checkOperand(operand);

        //then
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @DisplayName("연산자 유효성 검사")
    @CsvSource({"+, true", "-,true", "*,true", "/,true", "$, false"})
    void checkOperator(String operator, boolean expected) {
        //given //when
        boolean actual = stringCalculator.checkOperator(operator);

        //then
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @DisplayName("문자열 계산기 결과 검증")
    @CsvSource({"2 + 1, 3", "2 + 3 * 4 / 2, 10"})
    void calc(String values, long expected) {
        //given
        stringCalculator.setValues(values.split(" "));

        //when
        stringCalculator.calc();
        long result = stringCalculator.getResult();

        //then
        assertEquals(result, expected);
    }
}