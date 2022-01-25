package calculator;

import java.util.ArrayList;
import java.util.List;

public final class Numbers {

    private final List<Number> numbers;

    private Numbers() {
        this.numbers = new ArrayList<>();
    }

    private Numbers(List<Number> numberList) {
        this.numbers = numberList;
    }

    public static Numbers create() {
        return new Numbers();
    }

    public static Numbers of(List<Number> numberList) {
        return new Numbers(numberList);
    }

    public int size() {
        return this.numbers.size();
    }

    public void add(Number number) {
        this.numbers.add(number);
    }

    public Number sum() {
        int sum = this.numbers.stream()
            .mapToInt(Number::intValue)
            .sum();
        return Number.valueOf(sum);
    }
}
