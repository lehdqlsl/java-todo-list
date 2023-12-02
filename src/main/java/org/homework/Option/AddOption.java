package org.homework.Option;

import org.homework.model.ToDo;
import org.homework.model.ToDoRepository;
import org.homework.view.InputView;
import org.homework.view.OutputView;

public class AddOption implements OptionsInterface{

    private final ToDoRepository toDoRepository = ToDoRepository.getInstance();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

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
