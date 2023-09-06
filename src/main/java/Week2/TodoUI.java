package Week2;

import java.util.Scanner;

public class TodoUI {
    private Scanner sc = new Scanner(System.in);
    private TodoManager todoManager = new TodoManager();

    public void run() {
       Option option;

        do {
            System.out.println("옵션을 선택하세요: 1.추가, 2.삭제, 3.조회, 4.종료");
            String input = sc.nextLine();
            option = Option.fromValue(input);

            switch (option) {
                case ADD:
                    System.out.print("추가할 일을 입력하세요: ");
                    todoManager.add(sc.nextLine());
                    break;
                case REMOVE:
                    try{
                        System.out.print("삭제할 일의 ID를 입력하세요: ");
                        todoManager.remove(Integer.parseInt(sc.nextLine()));
                    }catch (NumberFormatException e) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                    }
                    break;
                case SELECT:
                    try{
                        System.out.print("조회할 할 일의 ID를 입력하세요: ");
                        todoManager.select(Integer.parseInt(sc.nextLine()));
                    } catch(NumberFormatException e) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                    }
                    break;
                case QUIT:
                    System.out.println("종료");
                    break;
                case INVALID:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }

        } while (option != Option.QUIT);
    }
}
