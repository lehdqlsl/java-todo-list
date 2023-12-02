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

    public int checkViewOptionSelect(String input){
        try {
            int viewOptionNumber = checkValidNumber(input);
            checkRangeViewOptionNumber(viewOptionNumber);
            return viewOptionNumber;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    public void checkRangeViewOptionNumber(int viewOptionNumber){
        if(!(viewOptionNumber >= 1 && viewOptionNumber <= 3)){
            throw new IllegalArgumentException();
        }
    }
}
