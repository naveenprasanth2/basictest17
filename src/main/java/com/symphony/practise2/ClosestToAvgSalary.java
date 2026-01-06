package com.symphony.practise2;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ClosestToAvgSalary {
    public static final List<Employee> employees = List.of(
            new Employee("John", "Doe", 75000),
            new Employee("Jane", "Smith", 80000),
            new Employee("Alice", "Johnson", 80000),
            new Employee("Bob", "Brown", 70000),
            new Employee("Charlie", "Davis", 75000)
    );

    static void main() {
        OptionalDouble optionalDouble = employees.stream().mapToDouble(Employee::salary).average();
        double avg;
        if (optionalDouble.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            avg = optionalDouble.getAsDouble();
        }
        employees.stream().collect(Collectors.groupingBy(x -> Math.abs(x.salary() - avg)))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .ifPresentOrElse(System.out::println, NoSuchElementException::new);
    }
}
