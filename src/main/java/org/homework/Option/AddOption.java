package org.homework.Option;

import org.homework.model.ToDo;
import org.homework.model.ToDoRepository;
import org.homework.view.InputView;
import org.homework.view.OutputView;

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
