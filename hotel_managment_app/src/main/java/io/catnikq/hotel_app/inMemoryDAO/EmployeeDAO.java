package io.catnikq.hotel_app.inMemoryDAO;

import io.catnikq.hotel_app.model.Employee;
import java.util.List;

public interface EmployeeDAO {

    void save(Employee employee);

    Employee getById(int employeeId);

    void update(Employee employee);

    void delete(int employeeId);

    List<Employee> getAll();
}
