package com.design.Decorator;

public class Espresso extends Beverage{
    Beverage beverage;
    public Espresso(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public int getCost() {
        System.out.println("brought Espresso");
        return this.beverage.getCost()+10;
    }
}
