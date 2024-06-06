package io.catnikq.hotel_app.DAO;

import io.catnikq.hotel_app.model.Database;
import io.catnikq.hotel_app.model.Employee;
//import io.catnikq.hotel_app.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAOImpl implements EmployeeDAO {

//    private final PersonDAO personDAO;
//
//    public EmployeeDAOImpl(PersonDAO personDAO) {
//        this.personDAO = personDAO;
//    }

    @Override
    public Employee get(int id) throws SQLException {
        Connection con = Database.getConnection();
        Employee employee = null;

        String sql = "SELECT employee_id, person_id, postion, salary FROM employee WHERE employee_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int person_id = rs.getInt("person_id");
            int emp_id = rs.getInt("employee_id");
            String position = rs.getString("position");
            Float salary = rs.getFloat("salary");
            String name = rs.getString("name");
            String address = rs.getString("address");
            String phone_number = rs.getString("phone_number");
            int age = rs.getInt("age");
            String gender = rs.getString("gender");

            employee = new Employee(person_id, emp_id, position, salary, name, address, phone_number, age, gender);
        }

        Database.closeResultSet(rs);
        Database.closePreparedStatement(ps);
        Database.closeConnection(con);
        return employee;
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int save(Employee employee) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(Employee employee) throws SQLException {
        Connection con = Database.getConnection();

        String sql = "INSERT INTO employee (person_id, position, salary) VALUES (?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

//        ps.setInt(1, employee.getEmployeeID());
        ps.setInt(1, employee.getId());
        ps.setString(2, employee.getPosition());
        ps.setDouble(3, employee.getSalary());

        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(con);

        return result;
    }

    @Override
    public int update(Employee employee) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Employee employee) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
