package com.design.Decorator;

public class Soymilk extends AddonDecorator{
    Beverage beverage;
    public Soymilk(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public int getCost() {
        System.out.println("addin the soyemilk");
        return this.beverage.getCost()+5;
    }
}
