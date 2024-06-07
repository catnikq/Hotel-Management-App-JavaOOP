package io.catnikq.hotel_app.service;

import inMemoryDAO.*;
import io.catnikq.hotel_app.model.*;
import io.catnikq.hotel_app.mockData.inMemoryDatabase;

import java.util.Date;

public class ServiceTest {
    
    public static void main(String[] args) {
        // Initialize DAOs
        EmployeeDAO employeeDAO = new inMemoryEmployeeDAO();
        CustomerDAO customerDAO = new inMemoryCustomerDAO();
        RoomDAO roomDAO = new inMemoryRoomDAO();
        BookingDAO bookingDAO = new inMemoryBookingDAO();
        PaymentDAO paymentDAO = new inMemoryPaymentDAO();

        // Initialize services with DAOs
        employeeService employeeService = new employeeService(employeeDAO);
        customerService customerService = new customerService(customerDAO);
        roomService roomService = new roomService(roomDAO);
        bookingService bookingService = new bookingService(bookingDAO, roomDAO, customerDAO);
        paymentService paymentService = new paymentService(paymentDAO, bookingDAO, roomDAO);

        // Test Employee Service
        Employee employee = new Employee();
        employee.setName("Alice");
        employee.setAddress("123 Main St");
        employee.setPhoneNumber("555-1234");
        employee.setAge(25);
        employee.setGender("F");
        employee.setPosition("Manager");
        employee.setSalary(50000);
        employeeService.addEmployee(employee);
        
        System.out.println("Employees: " + employeeService.getAllEmployees());

        // Test Customer Service
        Customer customer = new Customer();
        customer.setName("Bob");
        customer.setAddress("456 Elm St");
        customer.setPhoneNumber("555-5678");
        customer.setAge(28);
        customer.setGender("M");
        customerService.addCustomer(customer);
    }
}
