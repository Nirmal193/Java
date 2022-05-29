package com.design.prototype;

public abstract class Shape {
    public int x;
    public int y;
    public String color;

    public Shape() {}
    
     public Shape(Shape target){
         this.x = target.x;
         this.y = target.y;
         this.color = target.color;
     }
     public abstract Shape clone();
     
     @Override
     public boolean equals(Object object){
        if(!(object instanceof Shape))
            return false;
        Shape shape = (Shape) object;
        return shape.x == this.x && shape.y == this.y && shape.color.equals(this.color);
     }
    
}
