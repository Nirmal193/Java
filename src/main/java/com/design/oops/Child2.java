package com.design.oops;

public class Child2 extends Base{
    public void childmethod(){
        System.out.println("child2 : child2Method");
    }
    public void toBaseClass(){
        System.out.println("child2: toBaseClass");
        super.childInvoke();
    }
}
