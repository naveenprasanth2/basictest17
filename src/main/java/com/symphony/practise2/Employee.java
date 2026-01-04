package com.symphony.practise2;

public record Employee(String firstName, String lastName, double salary) {
    @Override
    public String toString() {
        return firstName + " " + lastName + " ($" + salary + ")";
    }
}
