package io.catnikq.hotel_app.inMemoryDAO;

import io.catnikq.hotel_app.mockData.inMemoryDatabase;
import io.catnikq.hotel_app.model.Employee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class inMemoryEmployeeDAO implements EmployeeDAO {

    private Map<Integer, Employee> employees = new HashMap<>();
    private int nextId = 1;

    @Override
    public void save(Employee employee) {
        employee.setId(nextId++);
        employees.put(employee.getId(), employee);
        System.out.println("Employee saved to in-memory DAO: " + employee);
    }

    @Override
    public Employee getById(int employeeId) {
        return employees.get(employeeId);
    }

    @Override
    public void update(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    @Override
    public void delete(int employeeId) {
        employees.remove(employeeId);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> allEmployees = new ArrayList<>(employees.values());
        System.out.println("Retrieving all employees from in-memory DAO: " + allEmployees);
        return allEmployees;
    }

}
