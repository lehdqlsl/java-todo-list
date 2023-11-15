package org.homework.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public void selectOption() {
        while (true) {
            try {
                System.out.println("옵션을 선택하세요: 1.추가, 2.삭제, 3.조회, 4.종료");
                String input =  scanner.nextLine();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
