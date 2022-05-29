package com.design.AbstractFactory;

public class WinCheckBox implements Checkbox{
    @Override
    public void check() {
        System.out.println("checking form a windows device");
    }
}
