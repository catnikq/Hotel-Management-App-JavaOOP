package io.catnikq.hotel_app.controller;

import io.catnikq.hotel_app.model.Employee;
import io.catnikq.hotel_app.service.employeeService;
import java.util.List;

public class EmployeeControllerImpl implements EmployeeController {

    private employeeService employeeService;

    public EmployeeControllerImpl(employeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int employeeID) {
        return employeeService.getEmployeeById(employeeID);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int employeeID) {
        employeeService.deleteEmployee(employeeID);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        System.out.println("Retrieving all employees: " + employees);
        return employees;
    }

}
