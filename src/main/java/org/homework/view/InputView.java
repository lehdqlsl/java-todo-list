package org.homework.view;

import org.homework.enums.Options;
import org.homework.util.InputCheck;

import java.util.Scanner;

public class InputView {
    private final InputCheck inputCheck = new InputCheck();
    Scanner scanner = new Scanner(System.in);

    public Options selectOption() {
        while (true) {
            try {
                System.out.println("옵션을 선택하세요: 1.추가, 2.삭제, 3.조회, 4.종료");
                return Options.getOption(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public String addInput() {
        System.out.println("할 일을 입력해 주세요");
        return scanner.nextLine();
    }

    public int inputNumber() {
        while (true) {
            try {
                System.out.println("ID를 입력해 주세요");
                return inputCheck.checkInputNumber(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
