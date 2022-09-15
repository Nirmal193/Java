package com.design.oops;

public class Child extends Base{
    private String someValue = "something";
    public void someMethod(){
        System.out.println("called from the child class");
    }
    public void childmethod(){
        System.out.println("child1 : child1Method");
    }
    public void toBaseClass(){
        System.out.println("child1: toBaseClass");
    }
    public void childInvoke(){
        System.out.println("child1: first Invoke");
    }
}
