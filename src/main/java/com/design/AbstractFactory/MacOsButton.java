package com.design.AbstractFactory;

public class MacOsButton implements Button{
    @Override
    public void paint() {
        System.out.println("Paintingt using macOS button");
    }
}
