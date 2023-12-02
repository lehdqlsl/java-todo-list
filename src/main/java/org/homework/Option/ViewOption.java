package org.homework.Option;

import org.homework.model.ToDoRepository;
import org.homework.view.InputView;
import org.homework.view.OutputView;

public class ViewOption implements OptionsInterface{

    private final int VIEW_SINGLE = 1;
    private final int VIEW_ALL = 2;
    private final ToDoRepository toDoRepository = ToDoRepository.getInstance();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    @Override
    public void process() {
        int viewOptionNumber = inputView.viewOptionSelect();
        if(viewOptionNumber == VIEW_SINGLE){
            viewSingle();
        }
        if(viewOptionNumber == VIEW_ALL){
            viewAll();
        }
    }

    public void viewSingle(){
        outputView.printSingleView(toDoRepository.getToDo(inputView.inputNumber()));
    }

    public void viewAll(){
        outputView.printAllView(toDoRepository.getAllToDo());
    }

    @Override
    public boolean isContinue() {
        return true;
    }
}
