package com.company.services;

import com.company.models.Employee;

import java.util.List;

public interface EmployeeService {
    void createEmployee(Employee emp);
    List<Employee> empList();
    void updateEmployee(int id);
    void deleteEmployee(int id);
}
