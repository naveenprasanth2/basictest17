package com.symphony.practise3;

public class CloneBreak {
    static void main() {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.hashCode());
        Singleton singleton1 = singleton.clone();
        System.out.println(singleton1.hashCode());
    }
}
