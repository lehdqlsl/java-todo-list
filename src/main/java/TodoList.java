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
        printGetMenu();
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                getSpecificItem();
                break;
            case 2:
                getAllItem();
                break;
            case 3:
                getRecentSortedItem();
                break;
            case 4:
                getOldSortedItem();
                break;
            case 5:
                searchItem();
                break;
            default:
                System.out.println("1~4 사이의 숫자만 입력해주세요.");
                break;
        }
    }

    public void getSpecificItem() {
        System.out.print("조회하고 싶은 일의 ID를 입력하세요: ");
        int id = scanner.nextInt();
        if (checkIndex(id)) {
            TodoItem todoItem = this.todoItem.get(id);
            System.out.println("ID: " + id);
            System.out.println("할 일 : " + todoItem.getTitle());
            System.out.println("상태: " + getStatusName(todoItem.getStatus()));
        }
    }

    public void completeTodoItem() {
        System.out.print("완료한 일의 ID를 입력하세요: ");
        int id = scanner.nextInt();
        if (checkIndex(id)) {
            TodoItem todoItem = this.todoItem.get(id);
            todoItem.setStatus(Status.DONE);
            System.out.println(this.todoItem.get(id).getTitle() + " 완료함");
        }
    }

    private String getStatusName(Status status) {
        return switch (status) {
            case DONE -> "완료";
            case YET -> "미완료";
        };
    }

    public void printTodoMenu() {
        System.out.println("===== 할 일 프로그램 =====");
        System.out.println("1. 할 일 추가하기");
        System.out.println("2. 할 일 삭제하기");
        System.out.println("3. 할 일 조회하기");
        System.out.println("4. 할 일 완료하기");
        System.out.println("5. 종료하기");
        System.out.println("=============================");
        System.out.print("번호 입력 --> ");
    }

    public void printGetMenu() {
        System.out.println("===== 조회 방법 =====");
        System.out.println("1. 특정 ID 조회하기");
        System.out.println("2. 전체 조회하기");
        System.out.println("3. 최근에 추가된 순서대로 조회하기");
        System.out.println("4. 오래된 순서대로 조회하기");
        System.out.println("5. 검색하기");
        System.out.println("====================");
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

    public void getAllItem() {
        System.out.println("===== 전체 출력 =====");
        todoItem.forEach((key, value) -> {
            System.out.println("ID: " + key);
            System.out.println("할 일 : " + value.getTitle());
            System.out.println("상태: " + getStatusName(value.getStatus()));
        });
    }

    public void getRecentSortedItem() {
        System.out.println("===== 최근에 추가된 순서대로 출력 =====");
        todoItem.entrySet().stream()
                .sorted(Map.Entry.<Integer, TodoItem>comparingByKey().reversed())
                .forEach(item -> {
                    System.out.println("ID: " + item.getKey());
                    System.out.println("할 일 : " + item.getValue().getTitle());
                    System.out.println("상태: " + getStatusName(item.getValue().getStatus()));
                });

    }


    public void getOldSortedItem() {
        System.out.println("===== 오래된 순서대로 출력 =====");
        todoItem.entrySet().stream()
                .sorted(Map.Entry.<Integer, TodoItem>comparingByKey())
                .forEach(item -> {
                    System.out.println("ID: " + item.getKey());
                    System.out.println("할 일 : " + item.getValue().getTitle());
                    System.out.println("상태: " + getStatusName(item.getValue().getStatus()));
                });
    }

    public void searchItem() {
        System.out.print("검색할 내용을 입력하세요: ");
        scanner.nextLine();
        String search = scanner.nextLine();
        todoItem.entrySet().stream()
                .filter(item -> item.getValue().getTitle().contains(search))
                .forEach(item -> {
                    System.out.println("ID: " + item.getKey());
                    System.out.println("할 일 : " + item.getValue().getTitle());
                    System.out.println("상태: " + getStatusName(item.getValue().getStatus()));
                });
    }

}
