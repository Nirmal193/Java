package com.design.prototype;

import java.util.HashMap;
import java.util.Map;

public class Clonefactory {
    private Map<String,Shape> cache = new HashMap<>();
    private final static int defaultx = 25;
    private final static int defaulty = 26;
    private final static String default_color = "red";


    //We can add a method which copies for the Object and go ahead


    // The following code is for the default value constructer
    public Clonefactory(){
        //crate the shapes
        Circle circle = new Circle();
        circle.x = defaultx;
        circle.y = defaulty;
        circle.radius = 15;
        circle.color = default_color;
    }
    public Shape get(String name){
        return cache.get(name).clone();
    }
    public void put(String name,Shape shape){
        cache.put(name,shape);
    }
}
