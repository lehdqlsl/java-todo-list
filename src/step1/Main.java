package step1;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        TodoDAO dao = new TodoDAO();

        int menu;
        do {
            System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 종료");
            menu = sc.nextInt();
            sc.nextLine();
            switch (menu) {
                case 1 :		//추가
                    String content = sc.nextLine();
                    dao.insert(content);
                    break;

                case 2 : 		//삭제
                    int deleteid = sc.nextInt();
                    dao.delete(deleteid);
                    break;

                case 3 :			//조회
                    int selectid = sc.nextInt();
                    dao.select(selectid);
                    break;

                case 4 :		//종료
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    System.exit(0);
                    break;

                default :  System.out.println("잘못된 입력입니다.");
            }

        } while (menu != 4);
    }


}
