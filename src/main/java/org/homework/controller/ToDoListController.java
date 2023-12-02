package org.homework.controller;

import org.homework.Option.*;
import org.homework.model.ToDo;
import org.homework.model.ToDoRepository;
import org.homework.view.InputView;
import org.homework.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class ToDoListController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final ToDoRepository toDoRepository = ToDoRepository.getInstance();
    private final Map<Options, OptionsInterface> optionHandler = new HashMap<>();

    public ToDoListController(){
        optionHandler.put(Options.ADD, new AddOption());
        optionHandler.put(Options.DELETE, new DeleteOption());
        optionHandler.put(Options.VIEW, new ViewOption());
        optionHandler.put(Options.EXIT, new ExitOption());
        optionHandler.put(Options.COMPLETE, new CompleteOption());
    }

    public void run(){
        boolean stop = true;
        while (stop){
            OptionsInterface option = optionHandler.get(inputView.selectOption());
            option.process();
            stop = option.isContinue();
            System.out.println("---------------------------------");
        }
    }
}
