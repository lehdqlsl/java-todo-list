package org.homework;

import org.homework.controller.ToDoListController;

public class Main {
    public static void main(String[] args) {
        ToDoListController toDoListController = new ToDoListController();
        toDoListController.run();
    }
}