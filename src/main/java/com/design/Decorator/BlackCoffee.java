package com.design.Decorator;

public class BlackCoffee extends Beverage{
    Beverage beverage;
    public BlackCoffee(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public int getCost() {
        System.out.println("getting black coffee");
        return this.beverage.getCost()+8;
    }
}
