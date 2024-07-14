package org.homework;

import java.util.List;

public class OutputView {

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
        System.out.println("할 일이 삭제되었습니다. ID: [ " + todo.getId() + " ]");
    }

    public void printFind(Todo todo) {
        System.out.println(String.format("%-5s %-30s %-10s %-10s", "ID", "내용", "상태", "마감일"));
        System.out.println("--------------------------------------------------------------");
        System.out.println(String.format("%-5d %-30s %-10s %-10s", todo.getId(), todo.getContents(), todo.getStatus(), todo.getDeadLine()));
    }

    public void printChangeStatus(Todo todo) {
        System.out.println("할 일의 상태가 [ " + todo.getStatus() + " ] 로 변경되었습니다. ID : [ " + todo.getId() + " ]");
    }

    public void printToDoList(List<Todo> todoList) {
        if (todoList != null && !todoList.isEmpty()) {
            System.out.println(String.format("%-5s %-30s %-10s %-10s", "ID", "내용", "상태", "마감일"));
            System.out.println("--------------------------------------------------------------");
            for (Todo todo : todoList) {
                System.out.println(String.format("%-5d %-30s %-10s %-10s", todo.getId(), todo.getContents(), todo.getStatus(), todo.getDeadLine()));
            }
        } else {
            System.out.println("오늘로부터 7일 이내의 할 일이 없습니다.");
        }
    }

    public void printSearchList(List<Todo> todoList) {
        if (todoList != null && !todoList.isEmpty()) {
            System.out.println(String.format("%-5s %-30s %-10s %-10s", "ID", "내용", "상태", "마감일"));
            System.out.println("--------------------------------------------------------------");
            for (Todo todo : todoList) {
                System.out.println(String.format("%-5d %-30s %-10s %-10s", todo.getId(), todo.getContents(), todo.getStatus(), todo.getDeadLine()));
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
