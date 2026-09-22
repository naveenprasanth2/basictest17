package com.symphony.practise3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionBreak {
    static void main() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.hashCode());
        Constructor<?> constructor = singleton.getClass().getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton singleton1 = (Singleton) constructor.newInstance();
        System.out.println(singleton1.hashCode());
    }
}
