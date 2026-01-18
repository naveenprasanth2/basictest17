package com.symphony.practise2;

import java.util.List;

public class StreamsForEachOrdered {
        public static final List<Employee> employees = List.of(
            new Employee("John", "Doe", 75000),
            new Employee("Jane", "Smith", 80000),
            new Employee("Alice", "Johnson", 80000),
            new Employee("Bob", "Brown", 70000),
            new Employee("Charlie", "Davis", 75000)
    );
    static void main() {
            employees.parallelStream().map(Employee::lastName).forEachOrdered(System.out::println);
    }
}
