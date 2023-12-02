package org.homework.Option;

public class CompleteOption implements OptionsInterface{
    @Override
    public void process() {
        outputView.printComplete(toDoRepository.completeList(inputView.inputNumber()));
    }

    @Override
    public boolean isContinue() {
        return true;
    }
}
