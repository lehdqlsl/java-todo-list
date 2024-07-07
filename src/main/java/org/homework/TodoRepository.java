package org.homework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TodoRepository {
    private Map<Integer, Todo> todoMap = new HashMap<>();
    private int mapId = 1;

    public Todo addTodo(String contents, LocalDate deadLine) {
        Todo todo = new Todo(mapId, contents, deadLine);
        todoMap.put(mapId++, todo);
        return todo;
    }

    public Optional<Todo> deleteTodo(int id) {
        return Optional.ofNullable(todoMap.remove(id));
    }

    public Optional<Todo> findTodo(int id) {
        return Optional.ofNullable(todoMap.get(id));
    }

    public Optional<Todo> changeStatus(int id) {
        return Optional.ofNullable(todoMap.get(id))
                .map(todo -> {
                    todo.setStatus(!todo.isStatus());
                    return todo;
                });
    }

    public List<Todo> findToDoList() {
        List<Todo> todoList = new ArrayList<>();
        todoMap.values().stream()
                .filter(this::is7DaysLeft)
                .sorted((o1, o2) -> o2.getDeadLine().compareTo(o1.getDeadLine()))
                .forEach(todoList::add);
        return todoList;
    }

    public List<Todo> findKeyword(String keyword) {
        List<Todo> todoList = new ArrayList<>();
        todoMap.values().stream()
                .filter(todo -> todo.getContents().contains(keyword))
                .sorted((o1, o2) -> o2.getDeadLine().compareTo(o1.getDeadLine()))
                .forEach(todoList::add);
        return todoList;
    }

    private boolean is7DaysLeft(Todo todo) {
        LocalDate today = LocalDate.now();
        LocalDate deadline = todo.getDeadLine();
        return !deadline.isBefore(today) && !deadline.isAfter(today.plusDays(7));
    }
}
