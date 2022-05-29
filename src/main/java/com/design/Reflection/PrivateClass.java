package com.design.Reflection;

public class PrivateClass {
    private String privateObject = null;
    public PrivateClass(String privateObject){
        this.privateObject = privateObject;
    }
    private String getPrivateObject(){
        return this.privateObject;
    }
}
