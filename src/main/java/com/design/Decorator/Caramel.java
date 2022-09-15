package com.design.Decorator;

public class Caramel extends AddonDecorator{
    Beverage beverage;
    public Caramel(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int getCost() {
        System.out.println("adding caramel");
        return this.beverage.getCost()+2;
    }
}
