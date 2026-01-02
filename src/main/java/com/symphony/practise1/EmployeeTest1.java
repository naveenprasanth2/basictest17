package com.symphony.practise1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class EmployeeTest1 {
    static void main() {
        EmployeeRepo repo = new EmployeeRepo();
       List<String> result =  repo.employees.stream().collect(Collectors.groupingBy(Employee::firstName, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .orElseThrow(NoSuchElementException::new);

        System.out.println(result);

    }
}
