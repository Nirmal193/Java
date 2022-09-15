package com.design.oops;

public class Base {
    private String someone;
    private String something;
    public void someMethod(){
        System.out.println("printing form the base class");
    }
    protected void baseMethod(){
        System.out.println("Base: BaseMethod");
    }
    public void toBaseClass(){
        System.out.println("Base: toBaseClass");
    }
    public void childInvoke(){
        System.out.println("Base: first Invoke");
    }
}
