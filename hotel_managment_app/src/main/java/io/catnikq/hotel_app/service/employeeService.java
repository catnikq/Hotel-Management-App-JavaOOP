package io.catnikq.hotel_app.service;

import io.catnikq.hotel_app.inMemoryDAO.EmployeeDAO;
import io.catnikq.hotel_app.model.Employee;

import java.util.List;

public class employeeService {

    private EmployeeDAO employeeDAO;

    public employeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void addEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    public Employee getEmployeeById(int employeeId) {
        return employeeDAO.getById(employeeId);
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.update(employee);
    }

    public void deleteEmployee(int employeeId) {
        employeeDAO.delete(employeeId);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeDAO.getAll();
        System.out.println("Retrieving all employees from DAO: " + employees);
        return employees;
    }
}
