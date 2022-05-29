package com.design.AbstractFactory;

public class WindowsFactory implements GuiFactory{
    @Override
    public Button createButton() {
        return new winButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckBox();
    }
}
