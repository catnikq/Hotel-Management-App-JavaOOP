package io.catnikq.hotel_app.mockData;

import io.catnikq.hotel_app.model.Booking;
import io.catnikq.hotel_app.model.Customer;
import io.catnikq.hotel_app.model.Employee;
import io.catnikq.hotel_app.model.Payment;
import io.catnikq.hotel_app.model.Person;
import io.catnikq.hotel_app.model.Room;
import io.catnikq.hotel_app.model.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class inMemoryDatabase {

    public static Map<Integer, Person> persons = new HashMap<>();
    public static Map<Integer, Customer> customers = new HashMap<>();
    public static Map<Integer, Employee> employees = new HashMap<>();
    public static Map<Integer, Room> rooms = new HashMap<>();
    public static Map<Integer, Booking> bookings = new HashMap<>();
    public static Map<Integer, Service> services = new HashMap<>();
    public static Map<Integer, Payment> payments = new HashMap<>();
    private static int personIdCounter = 1;
    private static int customerIdCounter = 1;
    private static int employeeIdCounter = 1;
    private static int roomIdCounter = 1;
    private static int bookingIdCounter = 1;
    private static int serviceIdCounter = 1;
    private static int paymentIdCounter = 1;

    public static int getNextPersonId() {
        return personIdCounter++;
    }

    public static int getNextCustomerId() {
        return customerIdCounter++;
    }

    public static int getNextEmployeeId() {
        return employeeIdCounter++;
    }

    public static int getNextRoomId() {
        return roomIdCounter++;
    }

    public static int getNextBookingId() {
        return bookingIdCounter++;
    }

    public static int getNextServiceId() {
        return serviceIdCounter++;
    }

    public static int getNextPaymentId() {
        return paymentIdCounter++;
    }

}
