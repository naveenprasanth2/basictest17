package com.symphony.practise3;

import java.io.*;

public class SerializeBreak {
    static void main() throws IOException, ClassNotFoundException {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.hashCode());
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("ser.ser"));
        outputStream.writeObject(singleton);
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("ser.ser"));
        Singleton singleton1 = (Singleton) inputStream.readObject();
        System.out.println(singleton1.hashCode());
    }
}
