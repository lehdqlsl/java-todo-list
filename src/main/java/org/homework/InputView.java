package org.homework;

import java.time.LocalDate;
import java.util.Scanner;

public class InputView {
    private Scanner sc = new Scanner(System.in);

    public int getOption() {
        System.out.println("옵션을 선택하세요: 1.추가, 2.삭제, 3.조회, 4.완료 처리, 5.전체 목록, 6.검색, 7.종료");
        while (!sc.hasNextInt()) {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
            sc.next();
        }
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public String getContents() {
        System.out.println("할 일을 입력해주세요 : ");
        return sc.nextLine();
    }

    public int getDeleteId() {
        System.out.println("삭제하실 할 일의 ID를 입력해주세요 : ");
        while (!sc.hasNextInt()) {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    public int getFindId() {
        System.out.println("조회하실 할 일의 ID를 입력해주세요 : ");
        while (!sc.hasNextInt()) {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    public LocalDate getDueDate() {
        System.out.println("마감일을 입력해주세요. (yyyy-MM-dd): ");
        while (true) {
            try {
                return LocalDate.parse(sc.nextLine());
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요. (yyyy-MM-dd): ");
            }
        }
    }

    public int getId() {
        System.out.println("완료 처리할 ID를 입력해주세요: ");
        while (!sc.hasNextInt()) {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    public String getKeyword() {
        System.out.println("검색할 내용을 입력해주세요: ");
        return sc.nextLine();
    }
}
