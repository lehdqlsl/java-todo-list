package org.homework;

public enum ToDoSelect {

    ADD(1),
    DELETE(2),
    REFER(3),
    END(4);

    private int select;

    private ToDoSelect(int select) {
        this.select = select;
    }

    public int getSelect() {
        return select;
    }
}
