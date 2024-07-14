package org.homework;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TodoService {
    private TodoRepository todoRepository = new TodoRepository();

    public Todo addTodo(String contents, LocalDate deadLine) {
        return todoRepository.addTodo(contents, deadLine);
    }

    public Todo deleteTodo(int id) {
        return todoRepository.deleteTodo(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 할 일이 없습니다."));
    }

    public Todo findTodo(int id) {
        return todoRepository.findTodo(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 할 일이 없습니다."));
    }

    public Todo changeStatus(int id) {
        return todoRepository.changeStatus(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 할 일이 없습니다."));
    }

    public List<Todo> findToDoList() {
        return todoRepository.getTodoMap().values().stream()
                .filter(this::is7DaysLeft)
                .sorted((o1, o2) -> o2.getDeadLine().compareTo(o1.getDeadLine()))
                .collect(Collectors.toList());
    }

    public List<Todo> findKeyword(String keyword) {
        return todoRepository.getTodoMap().values().stream()
                .filter(todo -> todo.getContents().contains(keyword))
                .sorted((o1, o2) -> o2.getDeadLine().compareTo(o1.getDeadLine()))
                .collect(Collectors.toList());
    }

    private boolean is7DaysLeft(Todo todo) {
        LocalDate today = LocalDate.now();
        LocalDate deadline = todo.getDeadLine();
        return !deadline.isBefore(today) && !deadline.isAfter(today.plusDays(7));
    }
}
