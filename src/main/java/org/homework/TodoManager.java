package org.homework;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class TodoManager {
    private int id = 1;
    private final HashMap<Integer, Todoitem> todolist = new HashMap<>();

    public int insert(String content) {
        Todoitem todoitem = new Todoitem(id, content, "", LocalDateTime.now());
        todolist.put(id, todoitem);
        return id++;
    }

    public boolean delete(int id) {
        return todolist.remove(id) != null;
    }

    public Todoitem select(int id) {
        return todolist.getOrDefault(id, null);
    }

    public Todoitem complete(int id) {
        Todoitem todoitem = todolist.get(id);

        if (todoitem != null) {
            todoitem.setStatus("[완료]");
            todolist.put(id, todoitem);
            return todoitem;
        } else {
            return null;
        }
    }

    public List<Todoitem> selectAll() {
        return new ArrayList<>(todolist.values());
    }


    public List<Todoitem> sortyByDateDesc() {
        List<Todoitem> sortList = new ArrayList<>(todolist.values());
        sortList.sort(Comparator.comparing(Todoitem::getRecord_date).reversed());
        return sortList;
    }

    public List<Todoitem> sortByDateAsc() {
        List<Todoitem> sortList = new ArrayList<>(todolist.values());
        sortList.sort(Comparator.comparing(Todoitem::getRecord_date));
        return sortList;
    }


    public List<Todoitem> search(String keyword) {
        List<Todoitem> searchResult = new ArrayList<>();

        for (Todoitem todoitem : todolist.values()) {
            if (todoitem.getContent().contains(keyword)) {
                searchResult.add(todoitem);
            }
        }
        return searchResult;
    }

}//class end
