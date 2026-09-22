package com.symphony.practise3;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {
    private Singleton() {
//        if (singleton != null)
//                throw new RuntimeException("Instance Already found");
    }
    private static volatile Singleton singleton;
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    @Override
    public Singleton clone() {
        try {
            Singleton clone = (Singleton) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
