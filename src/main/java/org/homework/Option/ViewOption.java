package org.homework.Option;

import org.homework.model.ToDo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ViewOption implements OptionsInterface{

    private final int VIEW_SINGLE = 1;
    private final int VIEW_ALL = 2;
    private final int KEYWORD = 3;
    private final int ASCENDING_OPTION = 1;
    private final int DESCENDING_OPTION = 2;


    @Override
    public void process() {
        int viewOptionNumber = inputView.selectViewOption();
        if(viewOptionNumber == VIEW_SINGLE){
            viewSingle();
        }
        if(viewOptionNumber == VIEW_ALL){
            viewAll();
        }
        if(viewOptionNumber == KEYWORD){
            viewKeyword();
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

    public void viewKeyword(){
        String keyword = inputView.inputKeyword();
        List<ToDo> allList = toDoRepository.getAllToDo();
        List<ToDo> keywordList = allList.stream()
                .filter(toDo -> toDo.getWork().contains(keyword))
                .collect(Collectors.toList());
        outputView.printAllView(keywordList);
    }

    @Override
    public boolean isContinue() {
        return true;
    }
}
