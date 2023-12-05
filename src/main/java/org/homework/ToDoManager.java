package org.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToDoManager {
    private Map<Integer, String> todoMap;
    private int currentId;

    public ToDoManager() {
        todoMap = new HashMap<>();
        currentId = 0;
    }

    public void addTodo(String todoContent) {
        currentId++;
        todoMap.put(currentId, todoContent);
        System.out.println("할 일이 추가되었습니다. ID: " + currentId);
    }

    public void deleteTodo(int todoId) {
        if (todoMap.containsKey(todoId)) {
            todoMap.remove(todoId);
            System.out.println("할 일이 삭제되었습니다. ID: " + todoId);
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }

    public void referTodo(int todoId) {
        if (todoMap.containsKey(todoId)) {
            String todoContent = todoMap.get(todoId);
            System.out.println("할 일 내용: " + todoContent);
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }


    public void completeTodo(int todoId){
        if (todoMap.containsKey(todoId)) {
            String todoContent = todoMap.get(todoId);
            todoMap.put(todoId," [완료] " + todoContent);
            System.out.println("할 일이 완료되었습니다. ID: " + todoId);
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }


    public void printTodos() {
        if (todoMap.isEmpty()) {
            System.out.println("등록된 할 일이 없습니다.");
        } else {
            System.out.println("현재 등록된 할 일 목록:");
            for (Map.Entry<Integer, String> entry : todoMap.entrySet()) {
                int todoId = entry.getKey();
                String todoContent = entry.getValue();
                String completionStatus = todoContent.startsWith("[완료]") ? "[완료]" : "[미완료]";
                System.out.println("ID: " + todoId + ", 내용: " + todoContent + ", 완료 상태: " + completionStatus);
            }
        }
    }

    public void printSortedTodos(int sortOrder) {
        List<Map.Entry<Integer, String>> sortedList = new ArrayList<>(todoMap.entrySet());

        // 정렬
        if (sortOrder == 1) {
            sortedList.sort(Map.Entry.<Integer, String>comparingByKey().reversed());
        } else if (sortOrder == 2) {
            sortedList.sort(Map.Entry.<Integer, String>comparingByKey());
        }

        System.out.println("정렬된 할 일 목록:");
        for (Map.Entry<Integer, String> entry : sortedList) {
            int todoId = entry.getKey();
            String todoContent = entry.getValue();
            String completionStatus = todoContent.startsWith("[완료]") ? "[완료]" : "[미완료]";
            System.out.println("ID: " + todoId + ", 내용: " + todoContent + ", 완료 상태: " + completionStatus);
        }
    }

    public void searchTodosByKeyword(String keyword) {
        List<Map.Entry<Integer, String>> searchResults = new ArrayList<>();

        for (Map.Entry<Integer, String> entry : todoMap.entrySet()) {
            String todoContent = entry.getValue();
            if (todoContent.toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(entry);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("키워드를 포함하는 할 일이 없습니다.");
        } else {
            System.out.println("키워드 검색 결과:");
            for (Map.Entry<Integer, String> entry : searchResults) {
                int todoId = entry.getKey();
                String todoContent = entry.getValue();
                String completionStatus = todoContent.startsWith("[완료]") ? "[완료]" : "[미완료]";
                System.out.println("ID: " + todoId + ", 내용: " + todoContent + ", 완료 상태: " + completionStatus);
            }
        }
    }


}
