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
        System.out.println("할 일이 추가되었습니다. ID >> [ " + todo.getId() + " ]");
    }

    public void printDelete(Todo todo) {
        if (todo != null) {
            System.out.println("할 일이 삭제되었습니다. ID >> [ " + todo.getId() + " ]");
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }

    public void printFind(Todo todo) {
        if (todo != null) {
            System.out.println("ID\t내용\t\t상태\t\t마감일");
            System.out.println("-----------------------------------");
            System.out.println(todo.toString());
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }

    public void printAll(List<Todo> todos) {
        if (todos.isEmpty()) {
            System.out.println("할 일이 없습니다.");
        } else {
            System.out.println("ID\t내용\t\t상태\t\t마감일");
            System.out.println("-----------------------------------");
            todos.forEach(todo -> System.out.println(todo.toString()));
        }
    }

    public void printComplete(Todo todo) {
        if (todo != null) {
            System.out.println("할 일이 완료되었습니다. ID >> [ " + todo.getId() + " ]");
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }

    public void printSearchResult(List<Todo> todos) {
        if (todos.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            System.out.println("ID\t내용\t\t상태\t\t마감일");
            System.out.println("-----------------------------------");
            todos.forEach(todo -> System.out.println(todo.toString()));
        }
    }

    public void printError(String message) {
        System.out.println("오류: " + message);
    }
}
