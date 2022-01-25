package calculator;

public class Number {
    private static final Integer MIN_NUMBER = 0;

    private final Integer number;

    private Number(String input) {
        validate(input);
        this.number = parseInt(input);
    }

    public static Number valueOfString(String input) {
        return new Number(input);
    }

    public int intValue() {
        return this.number;
    }

    private void validate(String input) {
        Integer number = parseInt(input);
        if (number < MIN_NUMBER) {
            throw new RuntimeException("양의 숫자만 입력해 주세요.");
        }
    }

    private Integer parseInt(String input) {
        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new RuntimeException("양의 숫자만 입력해 주세요.");
        }
    }
}
