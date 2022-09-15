package com.design.Decorator;

public class CoffeShop {
    public static void main(String[] args) {
       Beverage coffee = new Caramel(new
               Chocolate(new Soymilk(
                       new Espresso(new
                               Espresso(new
                               BaseCost())))));
        System.out.println(coffee.getCost());
    }
}
