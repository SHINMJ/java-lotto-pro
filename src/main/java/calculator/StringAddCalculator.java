package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private static final int DEFAULT_VALUE = 0;
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int CUSTOM_INPUT_GROUP = 2;
    private static final String DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_REGEX = Pattern.compile("//(.)\n(.*)");

    private final Numbers numbers;

    private StringAddCalculator(String input) {
        this.numbers = Numbers.of(split(input));
    }

    public static StringAddCalculator of(String input) {
        return new StringAddCalculator(input);
    }

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return DEFAULT_VALUE;
        }
        return StringAddCalculator.of(input).sum();
    }

    private int sum() {
        return this.numbers.sum().intValue();
    }

    private List<Number> split(String input) {
        Matcher matcher = CUSTOM_DELIMITER_REGEX.matcher(input);
        if (matcher.find()) {
            return splitWithCustomDelimiter(matcher);
        }

        return splitWithDelimiter(input, DELIMITER);
    }

    private List<Number> splitWithCustomDelimiter(Matcher matcher) {
        String delimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
        String input = matcher.group(CUSTOM_INPUT_GROUP);
        return splitWithDelimiter(input, delimiter);
    }

    private List<Number> splitWithDelimiter(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
            .map(Number::valueOfString)
            .collect(Collectors.toList());
    }

}
