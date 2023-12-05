package org.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToDoManager todoManager = new ToDoManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("1. 할 일 추가 | 2. 할 일 삭제 | 3. 할 일 목록 출력 | 4. 할 일 완료 |" +
                    " 5. 할 일 목록 전체 출력 | 6. 할 일 목록 정렬 후 출력 | 7. 할 일 키워드 검색 | 8. 종료\n선택하세요: ");

            try{
                int select = scanner.nextInt();
                scanner.nextLine();

                switch (select) {
                    case 1:
                        System.out.print("추가할 할 일을 입력하세요: ");
                        String todoContent = scanner.nextLine();
                        todoManager.addTodo(todoContent);
                        break;

                    case 2:
                        System.out.print("삭제할 할 일의 ID를 입력하세요: ");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine();
                        todoManager.deleteTodo(deleteId);
                        break;

                    case 3:
                        System.out.print("조회할 할 일의 ID를 입력하세요: ");
                        int referId = scanner.nextInt();
                        scanner.nextLine();
                        todoManager.referTodo(referId);
                        break;

                    case 4:
                        System.out.print("완료할 할 일의 ID를 입력하세요: ");
                        int completeId = scanner.nextInt();
                        scanner.nextLine();
                        todoManager.completeTodo(completeId);
                        break;

                    case 5:
                        todoManager.printTodos();
                        break;

                    case 6:
                        System.out.print("1. 최근에 추가한 순서 | 2. 오래된 순서\n선택하세요: ");
                        int sortOrder = scanner.nextInt();
                        scanner.nextLine();
                        todoManager.printSortedTodos(sortOrder);
                        break;

                    case 7:
                        System.out.print("검색할 키워드를 입력하세요: ");
                        String keyword = scanner.nextLine();
                        todoManager.searchTodosByKeyword(keyword);
                        break;

                    case 8:
                        System.out.println("프로그램을 종료합니다.");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("올바르지 않은 선택입니다. 다시 선택해주세요.");
                }
            }catch(InputMismatchException e){
                System.out.println("문자는 입력할 수 없습니다. 숫자를 입력해주세요.");
                scanner.nextLine();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("보기에 있는 번호로 다시 선택해주세요.");
            }
        }

    }
}