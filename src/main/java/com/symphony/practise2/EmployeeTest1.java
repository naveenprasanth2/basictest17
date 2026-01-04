package com.symphony.practise2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeTest1 {
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
                    .max(Comparator.comparingDouble(Map.Entry::getKey))
                    .map(Map.Entry::getValue)
                    .orElseThrow(NoSuchFieldError::new);
        System.out.println(result);

    }
}
