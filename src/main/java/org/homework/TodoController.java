package org.homework;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TodoController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private TodoService todoService = new TodoService();

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            try {
                int n = inputView.getOption();
                Option option = Option.valueOf(n);
                switch (option) {
                    case ADD:
                        addTodo();
                        break;
                    case DELETE:
                        deleteTodo();
                        break;
                    case VIEW:
                        findTodo();
                        break;
                    case COMPLETE:
                        completeTodo();
                        break;
                    case LIST:
                        listTodos();
                        break;
                    case SEARCH:
                        searchTodos();
                        break;
                    case EXIT:
                        outputView.exit();
                        isRunning = false;
                        break;
                    case NONE:
                        outputView.none();
                }
            } catch (DateTimeParseException e) {
                outputView.printError("날짜 형식이 잘못되었습니다. (yyyy-MM-dd 형식으로 입력하세요)");
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            } catch (Exception e) {
                outputView.printError("오류가 발생했습니다: " + e.getMessage());
            }
        }
    }

    private void addTodo() {
        String contents = inputView.getContents();
        LocalDate dueDate = inputView.getDueDate();
        outputView.printAdd(todoService.addTodo(contents, dueDate));
    }

    private void deleteTodo() {
        int id = inputView.getDeleteId();
        outputView.printDelete(todoService.deleteTodo(id));
    }

    private void findTodo() {
        int id = inputView.getFindId();
        outputView.printFind(todoService.findTodoById(id));
    }

    private void completeTodo() {
        int id = inputView.getId();
        outputView.printComplete(todoService.completeTodoById(id));
    }

    private void listTodos() {
        outputView.printAll(todoService.listTodos());
    }

    private void searchTodos() {
        String keyword = inputView.getKeyword();
        outputView.printSearchResult(todoService.searchTodos(keyword));
    }
}
