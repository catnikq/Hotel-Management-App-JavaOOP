package io.catnikq.hotel_app.controller;

import io.catnikq.hotel_app.model.Employee;
import java.util.List;

public interface EmployeeController {

    void addEmployee(Employee employee);

    Employee getEmployeeById(int employeeId);

    void updateEmployee(Employee employee);

    void deleteEmployee(int employeeId);

    List<Employee> getAllEmployees();
}
