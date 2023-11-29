package org.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TodoList {
    private final Map<Integer, TodoItem> todoItem;
    private int index;
    private final Scanner scanner;

    public TodoList() {
        this.todoItem = new HashMap<>();
        this.index = 1;
        this.scanner = new Scanner(System.in);
    }

    public void addTodoItem() {
        System.out.print("할 일을 입력하세요: ");
        String title = scanner.nextLine();
        TodoItem todoItem = new TodoItem(title);
        this.todoItem.put(index++, todoItem);
        System.out.println("할 일이 추가되었습니다. ID: " + (index - 1));
    }

    public void deleteTodoItem() {
        System.out.print("삭제하고 싶은 일의 ID를 입력하세요: ");
        int id = scanner.nextInt();
        if (checkIndex(id)) {
            this.todoItem.remove(id);
            System.out.println("ID : " + id + "번 삭제됨");
        }
    }

    public void getTodoItem() {
        System.out.print("조회하고 싶은 일의 ID를 입력하세요: ");
        int id = scanner.nextInt();
        if (checkIndex(id)) {
            TodoItem todoItem = this.todoItem.get(id);
            System.out.println("ID: " + id);
            System.out.println("할 일 : " + todoItem.getTitle());
        }
    }

    public void printTodoMenu() {
        System.out.println("===== 할 일 프로그램 =====");
        System.out.println("1. 할 일 추가하기");
        System.out.println("2. 할 일 삭제하기");
        System.out.println("3. 할 일 조회하기");
        System.out.println("4. 종료하기");
        System.out.println("=============================");
        System.out.print("번호 입력 --> ");
    }

    public boolean checkIndex(int id) {
        TodoItem todoItem = this.todoItem.get(id);
        if (id <= 0) {
            System.out.println("ID는 1 이상이어야 합니다.");
            return false;
        } else if(todoItem == null) {
            System.out.println("해당 ID는 존재하지 않습니다.");
            return false;
        }
        return true;
    }

}
