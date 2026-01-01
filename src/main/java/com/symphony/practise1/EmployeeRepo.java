package com.symphony.practise1;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {
    public List<Employee> employees;

    {
        employees = new ArrayList<>();
        employees.add(new Employee(1L, "John", "Doe"));
        employees.add(new Employee(2L, "Jane", "Doe"));
        employees.add(new Employee(3L, "Jack", "Doe"));
        employees.add(new Employee(4L, "Naveen", "Doe"));
        employees.add(new Employee(5L, "Bob", "Doe"));
        employees.add(new Employee(6L, "Jack", "Doe"));
        employees.add(new Employee(7L, "Jane", "Doe"));
        employees.add(new Employee(8L, "Bob", "Doe"));
        employees.add(new Employee(9L, "Jane", "Doe"));
        employees.add(new Employee(10L, "Jane", "Doe"));
        employees.add(new Employee(11L, "Bob", "Doe"));
        employees.add(new Employee(12L, "Bob", "Doe"));
    }


}
