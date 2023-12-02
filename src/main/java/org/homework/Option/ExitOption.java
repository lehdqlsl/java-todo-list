package org.homework.Option;

public class ExitOption implements OptionsInterface{
    @Override
    public void process() {
        outputView.printStop();
    }

    @Override
    public boolean isContinue() {
        return false;
    }
}
