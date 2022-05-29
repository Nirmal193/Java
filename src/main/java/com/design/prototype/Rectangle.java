package com.design.prototype;


public class Rectangle extends Shape{
    public int height;
    public int width;

    public Rectangle(){}
    
    public Rectangle(Rectangle target){
        super(target);
        this.height = target.height;
        this.width = target.width;
    }
    @Override
    public Shape clone() {
        return new Rectangle(this);
    }
    
    @Override
    public boolean equals(Object object){
        if(!(object instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) object;
        return this.height == rectangle.height && this.width == rectangle.width;
    }
}
