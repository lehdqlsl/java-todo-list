package org.homework.controller;

import org.homework.model.ToDoList;
import org.homework.view.InputView;

public class ToDoListController {
    private final InputView inputView = new InputView();
    private final ToDoList toDoList = new ToDoList();
    public boolean run() {
        int selectNumber = inputView.selectOption();
        return moveOption(selectNumber);
    }

    public boolean moveOption(int selectNumber) {
        if(selectNumber == 1){
            toDoList.addList();
            return true;
        }
        if(selectNumber == 2){
            toDoList.deleteList();
            return true;
        }
        if(selectNumber == 3){
            toDoList.viewList();
            return true;
        }
        if(selectNumber == 4){
            
        }
        return false;
    }
}
