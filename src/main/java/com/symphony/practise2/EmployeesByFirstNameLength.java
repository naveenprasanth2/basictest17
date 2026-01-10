package com.symphony.practise2;

import java.util.List;
import java.util.stream.Collector;

public class EmployeesByFirstNameLength {
    public static final List<Employee> employees = List.of(
            new Employee("John", "Doe", 75000),
            new Employee("Jane", "Smith", 80000),
            new Employee("Alice", "Johnson", 80000),
            new Employee("Bob", "Brown", 70000),
            new Employee("Charlie", "Davis", 75000)
    );

    static void main() {
        String result = employees.stream().collect(Collector.of(StringBuilder::new,
                (builder, emp) -> builder.append(emp.firstName()).append(", "),
                (builder1, builder2) -> {
                    builder1.append(builder2);
                    return builder1;
                }, builder -> !builder.isEmpty() ? builder.substring(0, builder.length() - 2) : ""));
        System.out.println(result);
    }
}
