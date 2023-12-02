package org.homework.Option;

import java.util.Arrays;

public enum Options {
    ADD("1"),
    DELETE("2"),
    VIEW("3"),
    EXIT("4");

    private final String optionNumber;

    Options(String optionNumber) {
        this.optionNumber = optionNumber;
    }

    public static Options getOption(String inputNumber) {
        return Arrays.stream(values())
                .filter(options -> options.optionNumber.equals(inputNumber))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
