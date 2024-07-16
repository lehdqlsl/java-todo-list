package org.homework;

import java.time.LocalDate;

public class Todo {
    private int id;
    private String desc;
    private Status status;
    private LocalDate dueDate;

    public Todo(String desc, LocalDate dueDate) {
        this.desc = desc;
        this.dueDate = dueDate;
        this.status = Status.미완료;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return String.format("%d\t%s\t\t%s\t\t%s", id, desc, status, dueDate);
    }
}
