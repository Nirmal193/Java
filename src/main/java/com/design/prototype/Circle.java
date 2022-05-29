package com.design.prototype;

import java.lang.annotation.Target;

public class Circle extends Shape{
    public int radius;

    public Circle(){}
    
    public Circle(Circle target){
        super(target);
        this.radius = target.radius;
    }

    @Override
    public Circle clone() {
        return new Circle(this);
    }
    @Override
    public boolean equals(Object object){
        if(!(object instanceof Circle)) return false;
        Circle circle = (Circle) object;
        return circle.radius == this.radius;
    }
    
}
