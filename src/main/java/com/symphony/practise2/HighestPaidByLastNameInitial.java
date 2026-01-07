package com.symphony.practise2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HighestPaidByLastNameInitial {
    public static final List<Employee> employees = List.of(
            new Employee("John", "Doe", 75000),
            new Employee("Jane", "Smith", 80000),
            new Employee("Alice", "Johnson", 80000),
            new Employee("Bob", "Brown", 70000),
            new Employee("Charlie", "Davis", 75000)
    );

    static void main() {
        Map<Character, Optional<Employee>> result = employees.stream()
                .collect(Collectors.groupingBy(
                        x -> Character.toUpperCase(x.lastName().charAt(0)),
                        Collectors.maxBy(Comparator.comparingDouble(Employee::salary))));
        result.forEach((x1, x2) -> System.out.println("The key is :" + x1 + " and the value is "+ x2.orElseThrow()));
    }
}
