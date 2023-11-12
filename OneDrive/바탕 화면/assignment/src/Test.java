

import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        String key = null;
        int value = 0;
        Scanner sc = new Scanner(System.in);
        boolean bool = true;
        int num = 0;
        // map안에 내용을 확인하기 위해서 반복자 iterator 생성
        Iterator it = map.keySet().iterator();

        while(bool) {
            System.out.println("1.메뉴 등록");
            System.out.println("2.메뉴별 가격 보기");
            System.out.println("3.종 료");
            System.out.print(">>>");
            num = sc.nextInt();
            switch(num) {
                case 1:
                    System.out.print("메뉴 입력 : ");
                    // key값 입력받기
                    key = sc.next();
                    // 중복된 key값이 있는지 확인하기
                    if(map.containsKey(key)==true) {
                        System.out.println("존재하는 메뉴 입니다.");
                    } else {
                        System.out.print("가격 입력 : ");
                        // value값 입력받기
                        value = sc.nextInt();
                        // 입력받은 key와 value값을 map에 추가하기
                        map.put(key, value);
                        System.out.println("등록 되었습니다.");
                    }
                    break;

                case 2:
                    // map에 최종적으로 담은 값을 iterator에 넣어주기
                    it = map.keySet().iterator();
                    // map에 값이 들어있는지 확인
                    while(it.hasNext()) {
                        // map에 들어있는 값을 key에 넣기
                        key = (String)it.next();
                        // key와 key가 가지고있는 value값 출력하기
                        System.out.println(key + " : " + map.get(key));
                    }
                    while(bool) {
                        System.out.print("1.수정\t" + "2.삭제\t" + "3.나가기");
                        num = sc.nextInt();
                        switch(num) {
                            case 1:
                                System.out.print("변경 메뉴이름 입력 : ");
                                key = sc.next();
                                System.out.print("수정 가격 입력 : ");
                                value = sc.nextInt();
                                System.out.println(map.get(key) + "->" + value);
                                System.out.println("변경 됐습니다.!!!");
                                // key가 가지고있는 value값 수정하기
                                map.replace(key, value);
                                break;

                            case 2:
                                // map에 최종적으로 담은 값을 iterator에 넣어주기
                                it = map.keySet().iterator();
                                // map에 값이 들어있는지 확인
                                while(it.hasNext()) {
                                    // map에 들어있는 값을 key에 넣기
                                    key = (String)it.next();
                                    // key와 key가 가지고있는 value값 출력하기
                                    System.out.println(key + " : " + map.get(key));
                                }
                                System.out.print("삭제할 이름 입력 : ");
                                key = sc.next();
                                System.out.println(key + "메뉴가 삭제 됐습니다.");
                                // map이 가지고 있는 key값과 key값이 가지고있는 value값을 삭제하기
                                map.remove(key);
                                break;

                            case 3:
                                bool = false;
                                break;
                        }
                    }
                    // case 2:를 탈출하기 위해 boole을 false로 바꾸었는데
                    // bool을 true로 바꿔주지 않으면 전체 while문을 탈출하기 때문에
                    // bool을 true로 변경
                    bool = true;
                    break;

                case 3:
                    // 전체 while문을 탈출하기 위해 bool을 false로 변경
                    bool = false;
                    System.out.println("종료 합니다.!!!");
                    break;
            }
        }
    }
}