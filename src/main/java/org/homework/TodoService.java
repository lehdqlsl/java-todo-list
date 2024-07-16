package org.homework;

import java.time.LocalDate;
import java.util.List;

public class TodoService {
    private TodoRepository todoRepository = new TodoRepository();

    public Todo addTodo(String contents, LocalDate dueDate) {
        return todoRepository.add(new Todo(contents, dueDate));
    }

    public Todo deleteTodo(int id) {
        return todoRepository.delete(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 할 일이 없습니다."));
    }

    public Todo findTodoById(int id) {
        return todoRepository.view(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 할 일이 없습니다."));
    }

    public Todo completeTodoById(int id) {
        Todo todo = todoRepository.view(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 할 일이 없습니다."));
        todo.setStatus(Status.완료);
        return todo;
    }

    public List<Todo> listTodos() {
        return todoRepository.findAllDueWithinDays(7);
    }

    public List<Todo> searchTodos(String keyword) {
        return todoRepository.searchByKeyword(keyword);
    }
}
