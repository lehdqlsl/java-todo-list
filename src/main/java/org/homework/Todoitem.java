package org.homework;

import java.time.LocalDateTime;

public class Todoitem {

    private int id;
    private String content;
    private String status;
    private LocalDateTime record_date;

    public Todoitem(int id, String content, String status, LocalDateTime now) {
        this.id = id;
        this.content = content;
        this.status = status;
        this.record_date = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getRecord_date() {
        return record_date;
    }

    public void setRecord_date(LocalDateTime record_date) {
        this.record_date = record_date;
    }
}
