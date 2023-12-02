package org.homework.Option;

import org.homework.model.ToDo;

public class AddOption implements OptionsInterface{

    @Override
    public void process() {
        ToDo toDo = new ToDo(inputView.addInput());
        toDoRepository.addList(toDo);
        outputView.printAdd(toDo.getId());
    }

    @Override
    public boolean isContinue() {
        return true;
    }
}
