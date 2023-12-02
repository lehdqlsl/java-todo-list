package org.homework.model;

import java.util.HashMap;

public class ToDoRepository {
    private static final ToDoRepository instance = new ToDoRepository();
    private static final HashMap<Integer, ToDo> toDoMap = new HashMap<>();
    private static int id = 0;


    public static ToDoRepository getInstance(){
        return instance;
    }
    private ToDoRepository() {

    }

    public void addList(ToDo toDo) {
        ++id;
        toDo.setId(id);
        toDoMap.put(id, toDo);
    }

    public ToDo getToDo(int inputID){
        return toDoMap.get(inputID);
    }

    public int deleteList(int inputID) {
        if (toDoMap.containsKey(inputID)) {
            toDoMap.remove(inputID);
            return inputID;
        }
        return -1;
    }
}
