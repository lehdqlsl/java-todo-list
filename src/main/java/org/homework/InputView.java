package org.homework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputView {
    private Scanner sc = new Scanner(System.in);
    private DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public String getOption() {
        System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 상태 변경, 5. 전체 할 일 목록, 6. 키워드 검색, 7. 종료");
        return sc.nextLine();
    }

    public String getContents() {
        System.out.println("할 일을 입력해주세요");
        return sc.nextLine();
    }

    public LocalDate getDeadLine() throws DateTimeParseException {
        while (true) {
            System.out.println("마감일을 입력해주세요. (yyyy-MM-dd) ");
            String deadline = sc.nextLine();
            return LocalDate.parse(deadline, datetimeformatter);
        }
    }

    public int getDeleteId() {
        System.out.println("삭제하실 할 일의 ID를 입력해주세요.");
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    public int getFindId() {
        System.out.println("조회하실 할 일의 ID를 입력해주세요.");
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    public int getChangeStatusId() {
        System.out.println("상태를 변경하실 할 일의 ID를 입력해주세요.");
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    public String getKeyWord() {
        System.out.println("검색하실 키워드를 입력해주세요.");
        return sc.nextLine();
    }
}
