package io.catnikq.hotel_app.service;

import io.catnikq.hotel_app.model.*;
import io.catnikq.hotel_app.mockData.inMemoryDatabase;

import java.util.Date;

public class ServiceTest {
    public static void main(String[] args) {
        // Initialize services
        employeeService employeeService = new employeeService();
        customerService customerService = new customerService();
        roomService roomService = new roomService();
        bookingService bookingService = new bookingService();
        paymentService paymentService = new paymentService();
        serviceService serviceService = new serviceService();

        // Test Employee Service
        Employee employee = new Employee();
        employee.setName("Alice");
        employee.setAddress("123 Main St");
        employee.setPhoneNumber("555-1234");
        employee.setGender("F");
        employee.setPosition("Manager");
        employee.setSalary(50000f);
        employeeService.addEmployee(employee);

        System.out.println("Employees: " + employeeService.getAllEmployees());

        // Test Customer Service
        Customer customer = new Customer();
        customer.setName("Bob");
        customer.setAddress("456 Elm St");
        customer.setPhoneNumber("555-5678");

        customerService.addCustomer(customer);

        System.out.println("Customers: " + customerService.getAllCustomers());

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

        // Test Service Service
        Service foodService = new Service() {
            @Override
            public String toString() {
                return getServiceName();
            }
        };
        foodService.setServiceName("Room Service - Food");
        foodService.setServiceDescription("Deluxe Food Package");
        foodService.setServicePrice(50.00);
        serviceService.addServiceToBooking(booking.getBookingID(), foodService);

        System.out.println("Booking Services: " + booking.getServices());
        System.out.println("Booking Total Price: " + booking.getTotalPrice());

        // Test Payment Service
        Payment payment = new Payment();
        payment.setBookingID(booking.getBookingID());
        payment.setAmount(booking.getTotalPrice());
        payment.setPaymentDate(new Date());
        payment.setPaymentMethod("Credit Card");
        paymentService.addPayment(payment);

        System.out.println("Payments: " + paymentService.getAllPayments());
        System.out.println("Room Status After Payment: " + roomService.getRoomByNumber(room.getRoomNumber()).getStatus());
    }
}
