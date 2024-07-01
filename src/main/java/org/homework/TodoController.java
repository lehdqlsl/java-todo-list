package org.homework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TodoController {
    TodoView todoView = new TodoView();
    TodoRepository todoRepository = new TodoRepository();

    public void start() {
        boolean flag = true;
        while (flag) {
            String n = todoView.getOption();
            Option option = Option.of(n);
            switch (option) {
                case ADD:
                    addTodo();
                    break;
                case DELETE:
                    deleteTodo();
                    break;
                case FIND:
                    findTodo();
                    break;
                case CHANGE_STATUS:
                    changeStatus();
                    break;
                case VIEWALL:
                    todoList();
                    break;
                case SEARCH:
                    search();
                    break;
                case EXIT:
                    todoView.exit();
                    flag = false;
                    break;
                case NONE:
                    todoView.none();
            }
        }
    }

    // 추가
    private void addTodo() {
        String contents = todoView.getContents();
        LocalDate deadLine = todoView.getDeadLine();
        todoView.printAdd(todoRepository.addTodo(contents, deadLine));
    }

    // 삭제
    private void deleteTodo() {
        int id = todoView.getDeleteId();
        todoView.printDelete(todoRepository.deleteTodo(id));
    }

    // 1개 조회
    private void findTodo() {
        int id = todoView.getFindId();
        todoView.printFind(todoRepository.findTodo(id));
    }

    // 상태 변경
    private void changeStatus() {
        int id = todoView.getChangeStatusId();
        todoView.printChangeStatus(todoRepository.changeStatus(id));
    }

    // 전체 할 일 목록 출력
    private void todoList() {
        todoView.printToDoList(todoRepository.findToDoList());
    }

    // 키워드 검색
    private void search() {
        String keyword = todoView.getKeyWord();
        todoView.printSearchList(todoRepository.findKeyword(keyword));
    }

}
