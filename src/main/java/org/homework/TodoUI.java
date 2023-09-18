package org.homework;


import java.util.List;
import java.util.Scanner;

public class TodoUI {

    private final TodoManager todoManager;
    private final Scanner sc = new Scanner(System.in);


    public TodoUI() {
        this.todoManager = new TodoManager();
    }

    public void run() throws Exception {
        InputOption option;
        do {
            System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 전체 조회, 5. 정렬 조회, 6. 완료, 7. 검색 8. 종료");

            String input = sc.nextLine();
            option = InputOption.of(input);

            switch (option) {
                case INSERT:        //추가
                    insert();
                    break;

                case DELETE:        //삭제
                    delete();
                    break;

                case SELECT:        //조회
                    select();
                    break;

                case SELECTALL:        //전체 할 일 목록 조회
                    selectAll();
                    break;

                case SELECTALLSORT:     //정렬 조회
                    selectAllsort();
                    break;

                case COMPLETE:      //완료
                    complete();
                    break;

                case SEARCH:
                    search();
                    break;


                case EXIT:          //종료
                    System.out.println("프로그램을 종료합니다.");
                    return;

                case INVALID_INPUT:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        } while (true);
    }

    private int getInput(String prompt) {
        int result = -1;

        while (true) {
            System.out.println(prompt);

            try {
                result = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력하세요.");
            }
        }

        return result;
    }

    private void insert() {
        System.out.println("할 일을 입력하세요.");
        String content = sc.nextLine();
        int id = todoManager.insert(content);
        System.out.println("할 일이 추가되었습니다. ID: " + id);
    }

    private void delete() {
        int id = getInput("삭제할 ID를 입력하세요.");

        if (todoManager.delete(id)) {
            System.out.println("할 일이 삭제되었습니다. ID: " + id);
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }

    }

    private void select() {
        int id = getInput("조회할 ID를 입력하세요.");
      
        Todoitem todoitem = todoManager.select(id);
        if (todoitem != null) {
            System.out.println("할 일 ID: " + id + " 내용: " + todoitem.getContent());

        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }

    private void complete() {
        int id = getInput("완료하고자 하는 할 일의 ID를 입력하세요.");

        Todoitem todoitem = todoManager.complete(id);
        if (todoitem != null) {
            System.out.println("할 일 ID: " + id + " 내용: " + todoitem.getContent() + todoitem.getStatus());
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }

    private void selectAll() {
        System.out.println("<전체 할 일 목록>");

        List<Todoitem> todoitemList = todoManager.selectAll();
        if (todoitemList.isEmpty()) {
            System.out.println("할 일 목록이 비어 있습니다.");
        } else {
            for (Todoitem todoitem : todoitemList) {
                printTodo(todoitem);
            }
        }
    }

    private void selectAllsort() {  //정렬기능
        System.out.println("전체 할 일 목록 정렬을 선택하세요. 1. 최신순(내림차순) 2. 오래된 순(오름차순)");
        String input = sc.nextLine();

        List<Todoitem> todoitemList;
        if ("1".equals(input)) {
            todoitemList = todoManager.sortyByDateDesc();
        } else if ("2".equals(input)) {
            todoitemList = todoManager.sortByDateAsc();
        } else {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        System.out.println("<전체 할 일 목록>");

        if (todoitemList.isEmpty()) {
            System.out.println("할 일 목록이 비어 있습니다.");
        } else {
            for (Todoitem todoitem : todoitemList) {
                printTodo(todoitem);
            }
        }
    }

    private void search() {
        System.out.println("검색할 키워드를 입력하세요.");
        String keyword = sc.nextLine();

        List<Todoitem> searchResult = todoManager.search(keyword);

        if (searchResult.isEmpty()) {
            System.out.println("키워드를 포함하는 할 일이 없습니다.");
        } else {
            System.out.println("<검색 결과>");
            for (Todoitem todoitem : searchResult) {
                printTodo(todoitem);
            }
        }
    }

    private void printTodo(Todoitem todoitem) {
        String status = todoitem.getStatus().isEmpty() ? "[미완료]" : todoitem.getStatus();
        System.out.println("ID: " + todoitem.getId() + " 내용: " + todoitem.getContent() + " 상태: " + status);
    }

}//class end
