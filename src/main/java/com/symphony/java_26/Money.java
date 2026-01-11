package com.symphony.java_26;

import lombok.ToString;

// Testing Valhalla features in IntelliJ
@ToString
public value class Money {
    private final int amount;
    private final String currency;
    private final StringBuilder stringBuilder;

    public Money(int amount, String currency, StringBuilder stringBuilder) {
        this.amount = amount;
        this.currency = currency;
        this.stringBuilder = stringBuilder;
    }

    static void main() {
        Money m1 = new Money(100, "USD", new StringBuilder("Naveen"));
        Money m2 = new Money(100, "USD",  new StringBuilder("Naveen"));
//        System.out.println("Value Object created: " + m1);
        System.out.println(m1.equals(m2));
    }
}
