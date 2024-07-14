package org.homework;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TodoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    TodoService todoService = new TodoService();

    public void run() {
        boolean flag = true;
        while (flag) {
            try {
                String n = inputView.getOption();
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
                        outputView.exit();
                        flag = false;
                        break;
                    case NONE:
                        outputView.none();
                }
            } catch (DateTimeParseException e) {
                outputView.printError("잘못된 날짜 형식입니다.");
            } catch (Exception e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    // 추가
    private void addTodo() throws DateTimeParseException {
        String contents = inputView.getContents();
        LocalDate deadLine = inputView.getDeadLine();
        outputView.printAdd(todoService.addTodo(contents, deadLine));
    }

    // 삭제
    private void deleteTodo() {
        int id = inputView.getDeleteId();
        outputView.printDelete(todoService.deleteTodo(id));
    }

    // 1개 조회
    private void findTodo() {
        int id = inputView.getFindId();
        outputView.printFind(todoService.findTodo(id));
    }

    // 상태 변경
    private void changeStatus() {
        int id = inputView.getChangeStatusId();
        outputView.printChangeStatus(todoService.changeStatus(id));
    }

    // 전체 할 일 목록 출력
    private void todoList() {
        outputView.printToDoList(todoService.findToDoList());
    }

    // 키워드 검색
    private void search() {
        String keyword = inputView.getKeyWord();
        outputView.printSearchList(todoService.findKeyword(keyword));
    }
}
