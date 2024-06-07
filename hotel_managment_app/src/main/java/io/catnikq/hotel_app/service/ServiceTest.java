package io.catnikq.hotel_app.service;

import inMemoryDAO.*;
import io.catnikq.hotel_app.model.*;
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
        // Test Room Service
        Room room = new Room();
        room.setRoomType("Deluxe");
        room.setPrice(200.00);
        room.setStatus("Available");
        roomService.addRoom(room);

        System.out.println("Rooms: " + roomService.getAllRooms());

        // Test Booking Service
        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setRoom(room);
        booking.setCheckInDate(new Date());
        booking.setCheckOutDate(new Date(System.currentTimeMillis() + 86400000)); // +1 day
        booking.setTotalPrice(room.getPrice()); // Initial total price is room price
        bookingService.addBooking(booking);

        System.out.println("Bookings: " + bookingService.getAllBookings());

        // Test Payment Service
        Payment payment = new Payment();
        payment.setBookingID(booking.getBookingID());
        payment.setAmount(booking.getTotalPrice());
        payment.setPaymentDate(new Date());
        payment.setPaymentMethod("Credit Card");
        paymentService.addPayment(payment);

        System.out.println("Payments: " + paymentService.getAllPayments());
        System.out.println("Room Status After Payment: " + roomService.getRoomByNumber(room.getRoomNumber()).getStatus());

        // Update Employee
        employee.setPosition("Senior Manager");
        employee.setSalary(60000);
        employeeService.updateEmployee(employee);
        System.out.println("Updated Employees: " + employeeService.getAllEmployees());

        // Delete Customer
        customerService.deleteCustomer(customer.getCustomerID());
        System.out.println("Customers after deletion: " + customerService.getAllCustomers());
    }
}
