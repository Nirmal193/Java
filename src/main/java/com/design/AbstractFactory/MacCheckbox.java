package com.design.AbstractFactory;

public class MacCheckbox implements Checkbox{
    @Override
    public void check() {
        System.out.println("checking using mac Os check box");
    }
}
