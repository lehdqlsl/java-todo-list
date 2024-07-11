package org.homework;

import java.time.LocalDate;
import java.util.HashMap;
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
                    todo.setStatus(todo.getStatus() == Status.완료 ? Status.미완료 : Status.완료);
                    return todo;
                });
    }

    public Map<Integer, Todo> getTodoMap() {
        return todoMap;
    }
}
