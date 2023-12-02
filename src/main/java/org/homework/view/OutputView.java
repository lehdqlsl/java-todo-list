package org.homework.view;

import org.homework.model.ToDo;

public class OutputView {
    public void printAdd(int id) {
        System.out.println("할 일이 추가되었습니다. ID: " + id);
    }

    public void printDelete(int id) {
        if (id < 0) {
            System.out.println("해당 ID의 할 일이 없습니다.");
        } else {
            System.out.println("할 일이 삭제되었습니다. ID: " + id);
        }
    }

    public void printView(ToDo toDo) {
        if (toDo == null) {
            System.out.println("해당 ID의 할 일이 없습니다.");
            return;
        }
        System.out.println("할 일 ID: " + toDo.getId() + " 내용: " + toDo.getWork());
    }

    public void printStop() {
        System.out.println("프로그램을 종료합니다.");
    }
}
