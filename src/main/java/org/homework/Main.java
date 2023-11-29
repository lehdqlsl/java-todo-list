package org.homework;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            todoList.printTodoMenu();
            int num = 0;
            try {
                num = scanner.nextInt();
                switch (num) {
                    case 1:
                        todoList.addTodoItem();
                        break;
                    case 2:
                        todoList.deleteTodoItem();
                        break;
                    case 3:
                        todoList.getTodoItem();
                        break;
                    case 4:
                        run = false;
                        System.out.println("프로그램 종료");
                        break;
                    default:
                        System.out.println("1~4 사이의 숫자만 입력해주세요.");
                        break;
                }

            }  catch (Exception e) {
                System.out.println("숫자만 입력해주세요.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}