package org.homework;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TodoRepository {
    private Map<Integer, Todo> todoMap = new HashMap<>();
    private int currentId = 1;

    public Todo add(Todo todo) {
        todo.setId(currentId++);
        todoMap.put(todo.getId(), todo);
        return todo;
    }

    public Optional<Todo> delete(int id) {
        return Optional.ofNullable(todoMap.remove(id));
    }

    public Optional<Todo> view(int id) {
        return Optional.ofNullable(todoMap.get(id));
    }

    public List<Todo> findAllDueWithinDays(int days) {
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusDays(days);
        return todoMap.values().stream()
                .filter(todo -> isDueWithinRange(todo, today, endDate))
                .collect(Collectors.toList());
    }

    public List<Todo> searchByKeyword(String keyword) {
        return todoMap.values().stream()
                .filter(todo -> containsKeyword(todo, keyword))
                .collect(Collectors.toList());
    }

    private boolean isDueWithinRange(Todo todo, LocalDate startDate, LocalDate endDate) {
        LocalDate dueDate = todo.getDueDate();
        return !dueDate.isBefore(startDate) && !dueDate.isAfter(endDate);
    }

    private boolean containsKeyword(Todo todo, String keyword) {
        return todo.getDesc().contains(keyword);
    }
}
