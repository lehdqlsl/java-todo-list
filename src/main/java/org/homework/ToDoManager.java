package org.homework;

import java.util.*;
import java.util.stream.Collectors;


public class ToDoManager {
    private final Map<Integer, String> todoMap; // ID(key) 와 할 일(value)을 가지는 map-1
    private final Map<String, String> todoStatus; // 할 일(key) 와 완료상태(value)를 가지는 map-2
    List<Map<Integer,String>> todoList;
    int ID; // todoMap key 값
    public ToDoManager() {
        todoMap = new HashMap<>();
        todoStatus = new HashMap<>();
        ID = 0;
        todoList = new ArrayList<>();
    }
    Map<Integer,String> map = new HashMap<Integer,String>(); // List에 넣을 map
    // 1.추가를 담당하는 메서드 addToDo
    public void addToDo(String todo) {
        String status = "미완료";
        ID += 1;
        todoMap.put(ID, todo);
        todoStatus.put(todoMap.get(ID),status);
        map.put(ID,todo);
        todoList.add(map);
        System.out.printf("할 일이 추가되었습니다. %d:%s[%s]%n", ID, todo,status);
        System.out.println(todoStatus);
        System.out.println(todoList);
    }
    // 2.삭제를 담당하는 메서드 deleteToDo
    public void deleteToDo(int ID) {
        if (todoMap.containsKey(ID)) {
            todoMap.remove(ID);
            todoStatus.remove(todoMap.get(ID));
            System.out.printf("할 일이 삭제되었습니다. ID:%d%n", ID);
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }
    // 3.조회를 담당하는 메서드 referToDo
    public void referToDo(int ID) {
        if (todoMap.containsKey(ID)) {
            todoMap.get(ID);
            System.out.printf("할 일 ID:%d 내용:%s%n", ID, todoMap.get(ID));
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }
    // 4. 완료 기능을 담당하는 메서드 completeToDo
    public void completeToDo(int ID) {
        if (todoMap.containsKey(ID)) {
            todoMap.get(ID);
            if(todoStatus.get(todoMap.get(ID)).equals("미완료")) {
                todoStatus.put(todoMap.get(ID),"완료");
                System.out.printf("%s[완료]%n",todoMap.get(ID));
                System.out.println(todoStatus);
            }
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }
    // 5. 전체 조회를 담당하는 메서드 entireToDo
    public void entireToDo() {
        if(!todoMap.isEmpty()) {
            for(Map.Entry<Integer,String> entry : todoMap.entrySet()) {
                    System.out.println("ID: " + entry.getKey() + "," +
                                       " 할 일: " + entry.getValue() + "," +
                                       " 완료상태: " + todoStatus.get(entry.getValue()));
            }
        }else {
            System.out.println("등록된 할 일이 없습니다.");
            }
    }
    // 6. 정렬 메서드 sortTodoList
    public void sortTodoList() {
        List<Map.Entry<Integer, String>> sortToDo = new ArrayList<Map.Entry<Integer,String>>(todoMap.entrySet());
        Collections.sort(sortToDo, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o2.getKey().compareTo(o1.getKey());
            }
        });
        for (Object object : sortToDo) {
            /*for(Map.Entry<Integer,String> entry : todoMap.entrySet()) {
                System.out.println("ID: " + entry.getKey() + "," +
                        " 할 일: " + entry.getValue() + "," +
                        " 완료상태: " + todoStatus.get(entry.getValue()));
            }*/
            System.out.println((Map.Entry)object + todoStatus.get(todoMap.get(ID)));
        }
    }

    // 7. 키워드를 통해 해당되는 할 일을 가져오는 메서드 searchKeyword
    public void searchKeyword(String kwd) {

       /* if(todoList.stream().anyMatch(s -> s.contains(kwd))) {
            System.out.println(todoList.stream().filter(s -> s.contains(kwd)).collect(Collectors.toList()));
        }else {
            System.out.println("키워드를 포함하는 할 일이 없습니다.");
        }
       String str =  todoMap.values().stream().filter(kwd::equals)
                                              .findAny()
                                              .orElse(null);
       System.out.println(str);*/
    }
}


