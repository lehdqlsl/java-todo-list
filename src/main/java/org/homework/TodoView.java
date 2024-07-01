package org.homework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class TodoView {
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public String getOption() {
        System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 상태 변경, 5. 전체 할 일 목록, 6. 키워드 검색, 7. 종료");
        return sc.nextLine();
    }

    public String getContents() {
        System.out.println("할 일을 입력해주세요");
        return sc.nextLine();
    }

    public LocalDate getDeadLine() {
        while (true) {
            try {
                System.out.println("마감일을 입력해주세요 (yyyy-MM-dd): ");
                String deadline = sc.nextLine();
                return LocalDate.parse(deadline, datetimeformatter);
            } catch (DateTimeParseException e) {
                System.out.println("잘못된 날짜 형식입니다. 다시 입력해주세요.");
            }
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

    public void exit() {
        System.out.println("프로그램을 종료합니다.");
    }

    public void none() {
        System.out.println("잘못된 입력입니다.");
    }

    public void printAdd(Todo todo) {
        System.out.println("할 일이 추가되었습니다. ID: [ " + todo.getId() + " ]");
    }

    public void printDelete(Todo todo) {
        if (todo != null) {
            System.out.println("할 일이 삭제되었습니다. ID: [ " + todo.getId() + " ]");
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }

    public void printFind(Todo todo) {
        if (todo != null) {
            System.out.println(todo);
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }

    public void printChangeStatus(Todo todo) {
        if (todo != null) {
            if (todo.isStatus()) {
                System.out.println("할 일의 상태가 [ 완료 ] 로 변경되었습니다. ID : [ " + todo.getId() + " ]");
            } else {
                System.out.println("할 일의 상태가 [ 미완료 ] 로 변경되었습니다. ID : [ " + todo.getId() + " ]");
            }
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }

    public void printToDoList(List<Todo> todoList) {
        System.out.println("ID\t내용\t\t\t\t\t상태\t\t\t마감일");
        System.out.println("-------------------------------------------------");
        for (Todo todo : todoList) {
            String status = todo.isStatus() ? "완료" : "미완료";
            System.out.println(todo.getId() + "\t" + todo.getContents() + "\t\t\t\t\t" + status + "\t\t" + todo.getDeadLine());
        }
    }

    public String getKeyWord() {
        System.out.println("검색하실 키워드를 입력해주세요.");
        return sc.nextLine();
    }

    public void printSearchList(List<Todo> todoList) {
        if (todoList != null) {
            System.out.println("ID\t내용\t\t\t\t\t상태\t\t\t마감일");
            System.out.println("-------------------------------------------------");
            for (Todo todo : todoList) {
                String status = todo.isStatus() ? "완료" : "미완료";
                System.out.println(todo.getId() + "\t" + todo.getContents() + "\t\t\t\t\t" + status + "\t\t" + todo.getDeadLine());
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }

    }

}
