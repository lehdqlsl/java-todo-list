package org.homework;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        return todoRepository.findToDoList();
    }

    public List<Todo> findKeyword(String keyword) {
        return todoRepository.findKeyword(keyword);
    }
}
