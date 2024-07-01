package org.homework;

import java.time.LocalDate;

public class Todo {
    private int id;
    private String contents;
    private boolean status;
    private LocalDate deadLine;

    public Todo(int id, String contents, LocalDate deadLine) {
        this.id = id;
        this.contents = contents;
        this.status = false;
        this.deadLine = deadLine;
    }

    public String toString() {
        return String.format("할 일 ID: [ %d ] 내용: [ %s ] 상태: [ %s ] 마감일: [ %s ]", id, contents, isStatus() ? "완료" : "미완료", deadLine);
    }

    public int getId() {
        return id;
    }

    public String getContents() {
        return contents;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }
}
