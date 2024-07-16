package org.homework;

public enum Option {
    ADD(1), DELETE(2), VIEW(3), COMPLETE(4), LIST(5), SEARCH(6), EXIT(7), NONE(0);

    private final int value;

    Option(int value) {
        this.value = value;
    }

    public static Option valueOf(int value) {
        for (Option option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        return NONE;
    }
}
