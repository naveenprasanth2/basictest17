package com.symphony.java_26;

import lombok.ToString;

// Testing Valhalla features in IntelliJ
@ToString
public value class Money1 {
    private final int amount;
    private final String currency;
    private final StringBuilder stringBuilder;

    public Money1(int amount, String currency, StringBuilder stringBuilder) {
        this.amount = amount;
        this.currency = currency;
        this.stringBuilder = stringBuilder;
    }

    static void main() {
        StringBuilder builder = new StringBuilder("Naveen");
        Money1 m1 = new Money1(100, "USD", builder);
        Money1 m2 = new Money1(100, "USD",  builder);
//        System.out.println("Value Object created: " + m1);
        System.out.println(m1.equals(m2));
    }
}
