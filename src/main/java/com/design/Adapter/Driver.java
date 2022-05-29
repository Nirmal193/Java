package com.design.Adapter;

public class Driver {
    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole(10);
        RoundPeg smallpeg = new RoundPeg(5);
        RoundPeg largepeg = new RoundPeg(20);
        SquarePeg mediumpeg = new SquarePeg(56);
        roundHole.isFits(smallpeg);
        roundHole.isFits(largepeg);
        SquarePegAdaptor squarePegAdaptor = new SquarePegAdaptor(mediumpeg);
        roundHole.isFits(squarePegAdaptor);
    }
}
