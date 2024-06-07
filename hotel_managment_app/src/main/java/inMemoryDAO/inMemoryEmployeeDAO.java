package inMemoryDAO;

import io.catnikq.hotel_app.mockData.inMemoryDatabase;
import io.catnikq.hotel_app.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class inMemoryEmployeeDAO implements EmployeeDAO {

    @Override
    public void save(Employee employee) {
        employee.setId(inMemoryDatabase.getNextPersonId());
        employee.setEmployeeID(inMemoryDatabase.getNextEmployeeId());
        inMemoryDatabase.employees.put(employee.getEmployeeID(), employee);
        inMemoryDatabase.persons.put(employee.getId(), employee);
    }

    @Override
    public Employee getById(int employeeId) {
        return inMemoryDatabase.employees.get(employeeId);
    }

    @Override
    public void update(Employee employee) {
        if (inMemoryDatabase.employees.containsKey(employee.getEmployeeID())) {
            inMemoryDatabase.employees.put(employee.getEmployeeID(), employee);
            inMemoryDatabase.persons.put(employee.getId(), employee);
        }
    }

    @Override
    public void delete(int employeeId) {
        Employee employee = inMemoryDatabase.employees.remove(employeeId);
        if (employee != null) {
            inMemoryDatabase.persons.remove(employee.getId());
        }
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(inMemoryDatabase.employees.values());
    }

}
