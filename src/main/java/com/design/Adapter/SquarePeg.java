package com.design.Adapter;

public class SquarePeg {
    private double width;

    public double getWidth() {
        return width;
    }

    public SquarePeg(double width) {
        this.width = width;
    }
    public double getArea(){
        return Math.pow(this.width,2);
    }
}
