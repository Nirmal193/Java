package com.design.prototype;


public class Driver {
    public static void main(String[] args) {

        //We could have a factory for generating the clones and optimise the code for better readability
        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.color = "red";
        circle.radius = 15;
        Circle circle2 = circle.clone();
        if(circle != circle2)
            System.out.println("The objects are not same but clonned");
        else
            System.out.println("The objects are coppied not clonned");
        if(circle.radius == circle2.radius)
            System.out.println("The objects are cloned perfectly");
        else
            System.out.println("The object variables are not cloned");
    }
}
