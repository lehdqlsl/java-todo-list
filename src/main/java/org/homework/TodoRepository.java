package org.homework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoRepository {
    private Map<Integer, Todo> todoMap = new HashMap<>();
    private int mapId = 1;

    public Todo addTodo(String contents, LocalDate deadLine) {
        Todo todo = new Todo(mapId, contents, deadLine);
        todoMap.put(mapId++, todo);
        return todo;
    }

    public Todo deleteTodo(int id) {
        return todoMap.remove(id);
    }


    public Todo findTodo(int id) {
        return todoMap.get(id);
    }

    public Todo changeStatus(int id) {
        Todo todo = todoMap.get(id);
        if (todo != null) {
            todo.setStatus(!todo.isStatus());
        }
        return todo;
    }

    public List<Todo> findToDoList() {
        List<Todo> todoList = new ArrayList<>();
        LocalDate today = LocalDate.now();
        todoMap.values().stream()
                .filter(todo -> !todo.getDeadLine().isBefore(today) && !todo.getDeadLine().isAfter(today.plusDays(7)))
                .forEach(todo -> todoList.add(todo));
        todoList.sort((o1, o2) -> o2.getDeadLine().compareTo(o1.getDeadLine()));
        return todoList;
    }

    public List<Todo> findKeyword(String keyword) {
        List<Todo> todoList = new ArrayList<>();
        todoMap.values().stream()
                .filter(todo -> todo.getContents().contains(keyword))
                .forEach(todo -> todoList.add(todo));
        todoList.sort((o1, o2) -> o2.getDeadLine().compareTo(o1.getDeadLine()));
        return todoList;

    }
}
