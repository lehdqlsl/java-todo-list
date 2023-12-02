package org.homework.Option;

import org.homework.model.ToDo;
import org.homework.model.ToDoRepository;
import org.homework.view.InputView;
import org.homework.view.OutputView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewOption implements OptionsInterface{

    private final int VIEW_SINGLE = 1;
    private final int VIEW_ALL = 2;
    private final int ASCENDING_OPTION = 1;
    private final int DESCENDING_OPTION = 2;
    private final ToDoRepository toDoRepository = ToDoRepository.getInstance();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    @Override
    public void process() {
        int viewOptionNumber = inputView.selectViewOption();
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
        List<ToDo> allList = toDoRepository.getAllToDo();
        int viewOptionNumber = inputView.selectOrderView();
        if(viewOptionNumber == ASCENDING_OPTION){
            allList.sort(Comparator.comparingInt(ToDo::getId));
        }
        if(viewOptionNumber == DESCENDING_OPTION){
            allList.sort(Comparator.comparingInt(ToDo::getId).reversed());
        }
        outputView.printAllView(allList);
    }

    @Override
    public boolean isContinue() {
        return true;
    }
}
