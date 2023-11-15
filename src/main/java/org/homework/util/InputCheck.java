package org.homework.util;

public class InputCheck {
    private static final int MIN_SELECT_NUMBER = 1;
    private static final int MAX_SELECT_NUMBER = 4;
    public int checkSelectNumber(String input) {
        int selectNumber = checkValidNumber(input);
        checkRangeNumber(selectNumber);
        return selectNumber;
    }

    public int checkValidNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public void checkRangeNumber(int selectNumber) {
        if(selectNumber > MAX_SELECT_NUMBER || selectNumber < MIN_SELECT_NUMBER){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
