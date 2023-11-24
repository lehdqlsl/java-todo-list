package org.homework.util;

public class InputCheck {

    public int checkInputNumber(String inputNumber){
        int inputId = checkValidNumber(inputNumber);
        return inputId;
    }

    public int checkValidNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
