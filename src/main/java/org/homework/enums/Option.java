package org.homework.enums;

import java.util.Arrays;

public enum Option {
    ADD("1"),
    DELETE("2"),
    VIEW("3"),
    EXIT("4");

    private final String optionNumber;

    Option(String optionNumber) {
        this.optionNumber = optionNumber;
    }

    static Option getOption(String inputNumber) {
        return Arrays.stream(values())
                .filter(option -> option.optionNumber.equals(inputNumber))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
