package step1;

import java.util.HashMap;
import java.util.Scanner;

public class TodoDAO {

    int id = 1;
    HashMap<Integer, String> map = new HashMap<>();

    public void insert(String content) {
        map.put(id, content);
        System.out.println("할 일이 추가되었습니다. ID:" + id);
        id ++;

    }

    public void delete(int id) {

        if(map.get(id) != null){
            map.remove(id);
            System.out.println( "할 일이 삭제되었습니다. ID:" + id);
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }


    public void select(int id) {
        if(map.get(id) != null){
            String content = map.get(id);
            System.out.println("할 일 ID: " + id + " 내용: " + content);
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }


}//class end
