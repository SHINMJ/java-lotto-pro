package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    @ParameterizedTest
    @CsvSource(value = {"1234;1234", "1;1", "1023928473;1023928473"}, delimiter = ';')
    void 문자열로_숫자클래스_생성(String input, int expected) {
        Number number = Number.valueOfString(input);
        assertThat(number.intValue()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"m", "E", "신명진", "-1", "#", ",", ":"})
    void 숫자클래스_실패케이스(String input) {
        assertThatThrownBy(() -> Number.valueOfString(input))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("양의 숫자만 입력해 주세요.");
    }
}
