package com.design.Adapter;

public class SquarePegAdaptor extends RoundPeg{
    private SquarePeg peg;

    public SquarePegAdaptor( SquarePeg peg){
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        return (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
    }
}
