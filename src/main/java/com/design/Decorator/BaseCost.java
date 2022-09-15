package com.design.Decorator;

public class BaseCost extends Beverage{
    public BaseCost() {
    }

    @Override
    public int getCost() {
        System.out.println("getting base cose");
        return 3;
    }
}
