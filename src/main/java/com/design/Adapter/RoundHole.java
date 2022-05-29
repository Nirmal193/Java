package com.design.Adapter;

public class RoundHole {
    private double radius;
    public RoundHole(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void isFits(RoundPeg peg){
        if(peg.getRadius() <= this.radius)
            System.out.println("the pag fits with the round hole");
        else
            System.out.println("The peg is bigger than the hole");
    }
}
