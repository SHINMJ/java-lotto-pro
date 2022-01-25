package calculator;

import java.util.Objects;

public final class Number {

    private static final Integer MIN_NUMBER = 0;
    private static final String EXCEPTION_MESSAGE = "양의 숫자만 입력해 주세요.";

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    private Number(String input) {
        validate(input);
        this.number = parseInt(input);
    }

    public static Number valueOf(int number) {
        return new Number(number);
    }

    public static Number valueOfString(String input) {
        return new Number(input);
    }

    public int intValue() {
        return this.number;
    }

    private void validate(String input) {
        int number = parseInt(input);
        if (number < MIN_NUMBER) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number other = (Number) o;
        return number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
