package org.homework.controller;

import org.homework.enums.Options;
import org.homework.model.ToDoList;
import org.homework.view.InputView;
import org.homework.view.OutputView;

public class ToDoListController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final ToDoList toDoList = new ToDoList();

    public boolean run() {
        Options option = inputView.selectOption();
        return moveOption(option);
    }

    public boolean moveOption(Options option) {
        if (Options.ADD.equals(option)) {
            doAdd();
            return true;
        }
        if (Options.DELETE.equals(option)) {
            doDelete();
            return true;
        }
        if (Options.VIEW.equals(option)) {
            doView();
            return true;
        }
        if (Options.EXIT.equals(option)) {
            stop();
        }
        return false;
    }

    public void doAdd() {
        int id = toDoList.addList(inputView.addInput());
        outputView.printAdd(id);
    }

    public void doDelete() {
        int id = toDoList.deleteList(inputView.inputNumber());
        outputView.printDelete(id);
    }

    public void doView() {
        int id = toDoList.viewList(inputView.inputNumber());
        outputView.printView(id, toDoList.getToDoMap());
    }

    public void stop() {
        outputView.printStop();
    }
}
