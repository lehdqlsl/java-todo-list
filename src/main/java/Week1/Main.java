package Week1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ToDoDAO td = new ToDoDAO();
        Scanner sc = new Scanner(System.in);
        int num;

        do {
            System.out.println("옵션을 선택하세요: 1.추가, 2.삭제, 3.조회, 4.종료");

            try {
                num = Integer.parseInt(sc.nextLine());

                switch (num) {
                    case 1:
                        System.out.print("추가할 일을 입력하세요: ");
                        td.add();
                        break;
                    case 2:
                        System.out.print("삭제할 일의 ID를 입력하세요: ");
                        td.remove(Integer.parseInt(sc.nextLine()));
                        break;
                    case 3:
                        System.out.print("조회할 할 일의 ID를 입력하세요: ");
                        td.select(Integer.parseInt(sc.nextLine()));
                        break;
                    case 4:
                        System.out.println("종료");
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 형식입니다. 숫자를 입력해주세요.");
                num = 0; // Reset num to loop again
            }

        } while (num != 4);

        sc.close();
    }

}
