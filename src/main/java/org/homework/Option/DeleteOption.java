package org.homework.Option;

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
