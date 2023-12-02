package org.homework.Option;

import org.homework.view.OutputView;

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
