package org.homework.model;

import java.util.HashMap;

public class ToDoList {
    private HashMap<Integer, String> toDoMap;
    private int id;

    public ToDoList() {
        this.toDoMap = new HashMap<>();
        this.id = 1;
    }

    public HashMap<Integer, String> getToDoMap() {
        return toDoMap;
    }

    public int addList(String addInput) {
        toDoMap.put(id, addInput);
        id++;
        return id - 1;
    }

    public int deleteList(int deleteNumber) {
        if (toDoMap.containsKey(deleteNumber)) {
            toDoMap.remove(deleteNumber);
            return deleteNumber;
        }
        return -1;
    }

    public int viewList(int viewNumber) {
        if (toDoMap.containsKey(viewNumber)) {
            return viewNumber;
        }
        return -1;
    }
}
