package com.symphony.practise;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class EmpTest {
    static void main() {
        List<Employee> employees = List.of(
                new Employee("Alice", "Engineering", 75000),
                new Employee("Bob", "Engineering", 48000),
                new Employee("Charlie", "HR", 32000),
                new Employee("David", "HR", 28000),
                new Employee("Eve", "Finance", 55000),
                new Employee("Frank", "Finance", 60000),
                new Employee("Grace", "Engineering", 52000),
                new Employee("Hannah", "Marketing", 47000),
                new Employee("Ivy", "Marketing", 51000),
                new Employee("Jack", "Engineering", 68000)
        );
        employees.stream().filter(x -> x.department().equals("Engineering") && x.salary() > 50000)
                .forEach(System.out::println);
        List<Map.Entry<String, Double>> averageSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::department,
                        Collectors.averagingDouble(Employee::salary))).entrySet().stream().toList();
        System.out.println(averageSalary);
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::name, String::compareTo)).toList();
        System.out.println(sortedEmployees);
        boolean isPresent = employees.stream().anyMatch(x -> x.department().equals("HR") && x.salary() < 3000);
        System.out.println(isPresent ? "The Employee is available" : "Employee not available");
        employees.stream()
                .max(Comparator.comparingDouble(Employee::salary))
                .ifPresentOrElse(System.out::println, NoSuchElementException::new);
    }
}
