package org.homework;

import java.time.LocalDate;

public class Todo {
    private int id;
    private String contents;
    private Status status;
    private LocalDate deadLine;

    public Todo(int id, String contents, LocalDate deadLine) {
        this.id = id;
        this.contents = contents;
        this.status = Status.미완료;
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return String.format("할 일 ID: [ %d ] 내용: [ %s ] 상태: [ %s ] 마감일: [ %s ]", id, contents, status, deadLine);
    }

    public int getId() {
        return id;
    }

    public String getContents() {
        return contents;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }
}
