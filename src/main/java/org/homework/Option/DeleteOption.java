package org.homework.Option;

import org.homework.model.ToDoRepository;
import org.homework.view.InputView;
import org.homework.view.OutputView;

public class DeleteOption implements OptionsInterface{
    @Override
    public void process() {
        outputView.printDelete(toDoRepository.deleteList(inputView.inputNumber()));
    }

    @Override
    public boolean isContinue() {
        return true;
    }
}
