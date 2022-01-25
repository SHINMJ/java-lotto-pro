package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumbersTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,1000})
    void 숫자일급컬렉션_숫자추가(int length) {
        Numbers numbers = Numbers.create();

        for (int i = 1; i <= length; i++) {
            numbers.add(Number.valueOfString(""+i));
        }

        assertThat(numbers.size()).isEqualTo(length);
    }

    @ParameterizedTest
    @CsvSource(value = {"3;6", "100;5050"}, delimiter = ';')
    void 숫자일급컬렉션_더하기(int length, int expected) {
        Numbers numbers = Numbers.create();

        for (int i = 1; i <= length; i++) {
            numbers.add(Number.valueOfString(""+i));
        }

        assertThat(numbers.sum().intValue()).isEqualTo(expected);
    }
}
