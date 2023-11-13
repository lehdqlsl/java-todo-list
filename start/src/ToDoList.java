import java.util.*;

public class ToDoList {

    public static void main(String[] args) {

        Map<Integer, String> toDoList = new HashMap<>();

        String todo = null;
        int ID = 0;
        // key, value 설정
        Scanner in = new Scanner(System.in);

        int option = 0; // 선택할 옵션
        int num = 0;
        boolean bool = true; // while문 true,false 값 , default는 true로 설정

        while (bool) {
            System.out.println("옵션을 선택해 주세요.");
            System.out.println("1.추가");
            System.out.println("2.삭제");
            System.out.println("3.조회");
            System.out.println("4.종료");
            option = in.nextInt();
            in.nextLine();

            switch (option) {
                case 1:
                    ID += 1 ;
                    while (bool) {
                        todo = in.nextLine();
                        toDoList.put(ID, todo);
                        System.out.println(toDoList);
                        System.out.printf("할 일이 등록되었습니다. %d:%s%n", ID, todo);
                        if(!toDoList.isEmpty()) {
                            break;
                        }
                    }
                    break;
                case 2:
                    ID = in.nextInt();
                    if (toDoList.containsKey(ID)){
                        toDoList.remove(ID);
                        System.out.printf("할 일이 삭제되었습니다. ID:%d%n", ID);
                        System.out.println(toDoList);
                    }else {
                        System.out.println("해당 ID의 할 일이 없습니다.");
                    }
                    break;
                case 3:
                    ID = in.nextInt();
                    if (toDoList.containsKey(ID)) {

                        System.out.printf("할 일 ID:%d 내용:%s%n",ID,toDoList.get(ID));
                    }else {
                        System.out.println("해당 ID의 할 일이 없습니다.");
                    }
                    break;
                case 4:
                    if(option == 4) {
                        bool = false;
                        System.out.println("프로그램을 종료합니다.");
                        break;
                    }
            }
        }

    }
}
