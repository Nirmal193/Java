package com.design.oops;

public class Driver {
    public static void main(String[] args) {
        Base b = new Child();
        Child c = (Child) new Base();
        c.someMethod();
    }
}
