package com.design.Decorator;

public class Chocolate extends AddonDecorator{
    Beverage beverage;
    public  Chocolate(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public int getCost() {
        System.out.println("adding chocolate");
        return this.beverage.getCost()+5;
    }
}
