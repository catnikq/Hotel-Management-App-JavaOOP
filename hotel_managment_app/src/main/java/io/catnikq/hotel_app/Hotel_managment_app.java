package io.catnikq.hotel_app;

import io.catnikq.hotel_app.GUI.Menu;
import io.catnikq.hotel_app.controller.*;
import io.catnikq.hotel_app.inMemoryDAO.*;
import io.catnikq.hotel_app.service.*;

public class Hotel_managment_app {

    public static void main(String[] args) {
        // Initialize DAOs
        EmployeeDAO employeeDAO = new inMemoryEmployeeDAO();
        CustomerDAO customerDAO = new inMemoryCustomerDAO();
        RoomDAO roomDAO = new inMemoryRoomDAO();
        BookingDAO bookingDAO = new inMemoryBookingDAO();

        // Initialize Services
        employeeService employeeService = new employeeService(employeeDAO);
        customerService customerService = new customerService(customerDAO);
        roomService roomService = new roomService(roomDAO);
        bookingService bookingService = new bookingService(bookingDAO, roomDAO, customerDAO);

        // Initialize Controllers
        EmployeeController employeeController = new EmployeeControllerImpl(employeeService);
        CustomerController customerController = new CustomerControllerImpl(customerService);
        RoomController roomController = new RoomControllerImpl(roomService);
        BookingController bookingController = new BookingControllerImpl(bookingService);

        // Start the application
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu(employeeController, customerController, roomController, bookingController).setVisible(true);
            }
        });
    }
}
