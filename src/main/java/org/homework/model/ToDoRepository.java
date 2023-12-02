package org.homework.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ToDoRepository {
    private static final String COMPLETE = "[완료]";
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

    public List<ToDo> getAllToDo(){
        return new ArrayList<ToDo>(toDoMap.values());
    }

    public int deleteList(int inputID) {
        if (toDoMap.containsKey(inputID)) {
            toDoMap.remove(inputID);
            return inputID;
        }
        return -1;
    }

    public int completeList(int inputID){
        if (toDoMap.containsKey(inputID)) {
            ToDo toDo = toDoMap.get(inputID);
            if (toDo.getWork().contains(COMPLETE)){
                return 0;
            }else{
                toDo.setWork(toDo.getWork() + COMPLETE);
            }
            return inputID;
        }
        return -1;
    }
}
