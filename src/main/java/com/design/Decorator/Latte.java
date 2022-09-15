package com.design.Decorator;

public class Latte extends Beverage{
    @Override
    public int getCost() {
        System.out.println("getting Latte");
        return 15;
    }
}
