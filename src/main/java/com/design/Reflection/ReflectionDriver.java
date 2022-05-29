package com.design.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDriver {
    /*
    getFields = gets all the public fields for that class
    getDeclaredFields = gets all the fields weather it is public or private
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {
        PrivateClass privateClass = new PrivateClass("Nirmal Kumar Rout");
        Field privateField = PrivateClass.class.getDeclaredField("privateObject");
        System.out.println(privateField.toString());
        privateField.setAccessible(true);
        String field = (String) privateField.get(privateClass);
        System.out.println("this is the field name with vallue added :- " + field);

        PrivateClass privateClass1 = new PrivateClass("Testing for private method");
        Method method = PrivateClass.class.getDeclaredMethod("getPrivateObject");
        System.out.println(method);
        method.setAccessible(true);
        String value = (String) method.invoke(privateClass1,null);
        System.out.println("The assigned value to that method is :- " + value);
    }
}
