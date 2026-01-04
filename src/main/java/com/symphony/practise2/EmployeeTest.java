package com.symphony.practise2;

import com.symphony.practise1.Employee;
import com.symphony.practise1.EmployeeRepo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class EmployeeTest {
    static void main() {
        EmployeeRepo repo = new EmployeeRepo();
       List<String> employees =  repo.employees.stream().collect(Collectors.groupingBy(Employee::firstName, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getKey))
               .map(Map.Entry::getValue)
                .orElseThrow(NoSuchElementException::new);
        System.out.println(employees);
    }
}
