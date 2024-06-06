package io.catnikq.hotel_app.service;

import io.catnikq.hotel_app.model.Employee;
import io.catnikq.hotel_app.mockData.inMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class employeeService {

    public void addEmployee(Employee employee) {
        employee.setId(inMemoryDatabase.getNextPersonId());
        employee.setEmployeeID(inMemoryDatabase.getNextEmployeeId());
        inMemoryDatabase.employees.put(employee.getEmployeeID(), employee);
        inMemoryDatabase.persons.put(employee.getId(), employee);
    }

    public Employee getEmployeeById(int employeeId) {
        return inMemoryDatabase.employees.get(employeeId);
    }

    public void updateEmployee(Employee employee) {
        if (inMemoryDatabase.employees.containsKey(employee.getEmployeeID())) {
            inMemoryDatabase.employees.put(employee.getEmployeeID(), employee);
            inMemoryDatabase.persons.put(employee.getId(), employee);
        }
    }

    public void deleteEmployee(int employeeId) {
        Employee employee = inMemoryDatabase.employees.remove(employeeId);
        if (employee != null) {
            inMemoryDatabase.persons.remove(employee.getId());
        }
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(inMemoryDatabase.employees.values());
    }
}
