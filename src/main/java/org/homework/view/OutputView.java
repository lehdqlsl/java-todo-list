package org.homework.view;

public class OutputView {
    public void printAdd(int id) {
        System.out.println("할 일이 추가되었습니다. ID: " + id);
    }

    public void printDelete(int id) {
        if (id < 0) {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }else{
            System.out.println("할 일이 삭제되었습니다. ID: " + id);
        }
    }
}
