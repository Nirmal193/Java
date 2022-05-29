package com.design.AbstractFactory;

public class winButton implements Button{
    @Override
    public void paint() {
        System.out.println("painting using windows button");
    }
}
