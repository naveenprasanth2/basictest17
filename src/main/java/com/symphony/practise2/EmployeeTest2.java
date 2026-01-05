package com.symphony.practise2;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeTest2 {
    public static final List<Employee> employees = List.of(
            new Employee("John", "Doe", 75000),
            new Employee("Jane", "Smith", 80000),
            new Employee("Alice", "Johnson", 80000),
            new Employee("Bob", "Brown", 70000),
            new Employee("Charlie", "Davis", 75000)
    );

    static void main() {
        List<Employee> result = employees.stream().collect(Collectors.groupingBy(Employee::salary, Collectors.toList()))
                .entrySet()
                .stream()
                .sorted((x1, x2) -> (int) (x2.getKey() - x1.getKey()))
                .limit(3)
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .toList();
        System.out.println(result);

    }
}
