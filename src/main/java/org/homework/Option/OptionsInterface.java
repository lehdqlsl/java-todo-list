package org.homework.Option;

import org.homework.model.ToDoRepository;
import org.homework.view.InputView;
import org.homework.view.OutputView;

public interface OptionsInterface {
    ToDoRepository toDoRepository = ToDoRepository.getInstance();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    void process();
    boolean isContinue();
}
