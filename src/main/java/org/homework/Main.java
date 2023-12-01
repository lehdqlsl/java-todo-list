package org.homework;
import java.util.Scanner;

public class Main {
    public enum SelectOption {
        ADD(1), DELETE(2), REFER(3), COMPLETE(4), Entire(5), SORT(6);
        private final int option;

        SelectOption(int option) {
            this.option = option;
        }
        public int option() {
            return option;
        }
    }

    public static void main(String[] args) {
        ToDoManager toDoManager = new ToDoManager();
        Scanner user = new Scanner(System.in);
        boolean isTrue = true;


        try {
            while (isTrue) {
                System.out.println("옵션을 선택해주세요.");
                System.out.println(" 1 : 추가");
                System.out.println(" 2 : 삭제");
                System.out.println(" 3 : 조회");
                System.out.println(" 4 : 완료");
                System.out.println(" 5 : 전체조회");
                System.out.println(" 6 : 정렬");
                System.out.println(" 7 : 종료");

                int option = user.nextInt();
                user.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("추가 할 일을 입력해주세요.");
                        String todo = user.nextLine();
                        toDoManager.addToDo(todo);
                        break;

                    case 2:
                        System.out.println("삭제 하고싶은 할 일의 ID를 입력해주세요.");
                        int ID = user.nextInt();
                        toDoManager.deleteToDo(ID);
                        break;

                    case 3:
                        System.out.println("조회하고 싶은 할 일의 ID를 입력해주세요.");
                        ID = user.nextInt();
                        toDoManager.referToDo(ID);
                        break;

                    case 4:
                        System.out.println("완료로 변경하고 싶은 할 일의 ID를 입력해주세요.");
                        ID = user.nextInt();
                        toDoManager.completeToDo(ID);
                        break;

                    case 5:
                        System.out.println("<할 일 목록>");
                        toDoManager.entireToDo();
                        break;

                    case 6:
                        System.out.println("정렬 방식을 선택해주세요.");
                        //int sort = user.nextInt();
                        toDoManager.sortTodoList();
                        break;
                    case 7:
                        isTrue = false;
                        System.out.println("프로그램을 종료합니다.");
                        break;
                }
            }
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            System.out.println("잘못된 입력사항입니다. 입력 주의사항을 확인 후 다시 실행해주세요.");
            user.close();
        }
    }
}

