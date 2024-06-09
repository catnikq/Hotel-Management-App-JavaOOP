package io.catnikq.hotel_app.GUI;

import io.catnikq.hotel_app.inMemoryDAO.CustomerDAO;
import io.catnikq.hotel_app.inMemoryDAO.BookingDAO;
import io.catnikq.hotel_app.inMemoryDAO.EmployeeDAO;
import io.catnikq.hotel_app.inMemoryDAO.inMemoryRoomDAO;
import io.catnikq.hotel_app.inMemoryDAO.inMemoryEmployeeDAO;
import io.catnikq.hotel_app.inMemoryDAO.inMemoryCustomerDAO;
import io.catnikq.hotel_app.inMemoryDAO.inMemoryBookingDAO;
import io.catnikq.hotel_app.inMemoryDAO.RoomDAO;
import io.catnikq.hotel_app.controller.*;
import io.catnikq.hotel_app.service.bookingService;
import io.catnikq.hotel_app.service.customerService;
import io.catnikq.hotel_app.service.employeeService;
import io.catnikq.hotel_app.service.roomService;

import javax.swing.*;
import java.awt.*;

public class ViewData extends JFrame {

    private EmployeeController employeeController;
    private CustomerController customerController;
    private RoomController roomController;
    private BookingController bookingController;

    private JTabbedPane tabbedPane;
    private JPanel employeePanel;
    private JPanel customerPanel;
    private JPanel emptyRoomPanel;
    private JPanel bookedRoomPanel;
    private JPanel checkedOutRoomPanel;
    private JTable employeeTable;
    private JTable customerTable;
    private JTable emptyRoomTable;
    private JTable bookedRoomTable;
    private JTable checkedOutRoomTable;

    public ViewData(EmployeeController employeeController, CustomerController customerController, RoomController roomController, BookingController bookingController) {
        this.employeeController = employeeController;
        this.customerController = customerController;
        this.roomController = roomController;
        this.bookingController = bookingController;
        initComponents();
    }

    private void initComponents() {
        setTitle("View Data");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        employeePanel = new JPanel(new BorderLayout());
        customerPanel = new JPanel(new BorderLayout());
        emptyRoomPanel = new JPanel(new BorderLayout());
        bookedRoomPanel = new JPanel(new BorderLayout());
        checkedOutRoomPanel = new JPanel(new BorderLayout());

        employeeTable = new JTable();
        customerTable = new JTable();
        emptyRoomTable = new JTable();
        bookedRoomTable = new JTable();
        checkedOutRoomTable = new JTable();

        employeePanel.add(new JScrollPane(employeeTable), BorderLayout.CENTER);
        customerPanel.add(new JScrollPane(customerTable), BorderLayout.CENTER);
        emptyRoomPanel.add(new JScrollPane(emptyRoomTable), BorderLayout.CENTER);
        bookedRoomPanel.add(new JScrollPane(bookedRoomTable), BorderLayout.CENTER);
        checkedOutRoomPanel.add(new JScrollPane(checkedOutRoomTable), BorderLayout.CENTER);

        tabbedPane.addTab("Employees", employeePanel);
        tabbedPane.addTab("Customers", customerPanel);
        tabbedPane.addTab("Empty Rooms", emptyRoomPanel);
        tabbedPane.addTab("Booked Rooms", bookedRoomPanel);
        tabbedPane.addTab("Checked Out Rooms", checkedOutRoomPanel);

        add(tabbedPane);
        loadData();
    }

    public void loadData() {
        loadEmployeeData();
        loadCustomerData();
        loadEmptyRoomData();
        loadBookedRoomData();
        loadCheckedOutRoomData();
    }

    private void loadEmployeeData() {
        String[] columnNames = {"ID", "Name", "Address", "Phone Number", "Age", "Gender", "Position", "Salary"};
        Object[][] data = employeeController.getAllEmployees().stream()
                .map(emp -> new Object[]{emp.getId(), emp.getName(), emp.getAddress(), emp.getPhoneNumber(), emp.getAge(), emp.getGender(), emp.getPosition(), emp.getSalary()})
                .toArray(Object[][]::new);
        employeeTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    private void loadCustomerData() {
        String[] columnNames = {"ID", "Name", "Address", "Phone Number", "Age", "Gender"};
        Object[][] data = customerController.getAllCustomers().stream()
                .map(cust -> new Object[]{cust.getId(), cust.getName(), cust.getAddress(), cust.getPhoneNumber(), cust.getAge(), cust.getGender()})
                .toArray(Object[][]::new);
        customerTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    private void loadEmptyRoomData() {
        String[] columnNames = {"Room Number", "Room Type", "Price", "Status"};
        Object[][] data = roomController.getAllRooms().stream()
                .filter(room -> room.getStatus().equals("Available"))
                .map(room -> new Object[]{room.getRoomNumber(), room.getRoomType(), room.getPrice(), room.getStatus()})
                .toArray(Object[][]::new);
        emptyRoomTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    private void loadBookedRoomData() {
        String[] columnNames = {"Room Number", "Room Type", "Price", "Check In Date", "Services", "Total Price"};
        Object[][] data = bookingController.getAllBookings().stream()
                .filter(booking -> booking.getRoom().getStatus().equals("Occupied"))
                .map(booking -> new Object[]{booking.getRoom().getRoomNumber(), booking.getRoom().getRoomType(), booking.getRoom().getPrice(), booking.getCheckInDate(), booking.getServices(), booking.getTotalPrice()})
                .toArray(Object[][]::new);
        bookedRoomTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    private void loadCheckedOutRoomData() {
        String[] columnNames = {"Room Number", "Room Type", "Customer Name", "Check In Date", "Check Out Date", "Total Price"};
        Object[][] data = bookingController.getAllBookings().stream()
                .filter(booking -> booking.getRoom().getStatus().equals("Available"))
                .map(booking -> new Object[]{booking.getRoom().getRoomNumber(), booking.getRoom().getRoomType(), booking.getCustomer().getName(), booking.getCheckInDate(), booking.getCheckOutDate(), booking.getTotalPrice()})
                .toArray(Object[][]::new);
        checkedOutRoomTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new inMemoryEmployeeDAO();
        CustomerDAO customerDAO = new inMemoryCustomerDAO();
        RoomDAO roomDAO = new inMemoryRoomDAO();
        BookingDAO bookingDAO = new inMemoryBookingDAO();

        employeeService employeeService = new employeeService(employeeDAO);
        customerService customerService = new customerService(customerDAO);
        roomService roomService = new roomService(roomDAO);
        bookingService bookingService = new bookingService(bookingDAO, roomDAO, customerDAO);

        EmployeeController employeeController = new EmployeeControllerImpl(employeeService);
        CustomerController customerController = new CustomerControllerImpl(customerService);
        RoomController roomController = new RoomControllerImpl(roomService);
        BookingController bookingController = new BookingControllerImpl(bookingService);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewData(employeeController, customerController, roomController, bookingController).setVisible(true);
            }
        });
    }
}
