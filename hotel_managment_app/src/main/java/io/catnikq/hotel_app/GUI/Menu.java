package io.catnikq.hotel_app.GUI;

import io.catnikq.hotel_app.controller.*;
import inMemoryDAO.*;
import io.catnikq.hotel_app.service.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private EmployeeController employeeController;
    private CustomerController customerController;
    private RoomController roomController;
    private BookingController bookingController;

    public Menu(EmployeeController employeeController, CustomerController customerController, RoomController roomController, BookingController bookingController) {
        this.employeeController = employeeController;
        this.customerController = customerController;
        this.roomController = roomController;
        this.bookingController = bookingController;
        initComponents();
    }

    private void initComponents() {
        setTitle("Hotel Management System"); 
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        // Add Menu
        JMenu addMenu = new JMenu("Add");
        JMenuItem addEmployeeMenuItem = new JMenuItem("Add a new Employee");
        addEmployeeMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new AddEmployee(employeeController).setVisible(true);
            }
        });
        JMenuItem addBookingMenuItem = new JMenuItem("Book a Room");
        addBookingMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new AddBooking(bookingController, customerController, roomController).setVisible(true);
            }
        });
        JMenuItem addRoomMenuItem = new JMenuItem("Add a new Room");
        addRoomMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new AddRoom(roomController).setVisible(true);
            }
        });
        addMenu.add(addEmployeeMenuItem);
        addMenu.add(addBookingMenuItem);
        addMenu.add(addRoomMenuItem);
        menuBar.add(addMenu);

        // Edit Menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem editEmployeeMenuItem = new JMenuItem("Edit an Employee");
        editEmployeeMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new EditEmployee(employeeController).setVisible(true);
            }
        });
        JMenuItem editRoomMenuItem = new JMenuItem("Edit a Room");
        editRoomMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new EditRoom(roomController).setVisible(true);
            }
        });
        editMenu.add(editEmployeeMenuItem);
        editMenu.add(editRoomMenuItem);
        menuBar.add(editMenu);

        // Service Menu
        JMenu serviceMenu = new JMenu("Service");
        JMenuItem checkOutMenuItem = new JMenuItem("Check out");
        checkOutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new AddCheckOut(roomController).setVisible(true);
            }
        });
        JMenuItem addServiceMenuItem = new JMenuItem("Add extra Service");
        addServiceMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new AddService(bookingController, roomController).setVisible(true);
            }
        });
        serviceMenu.add(checkOutMenuItem);
        serviceMenu.add(addServiceMenuItem);
        menuBar.add(serviceMenu);

        setJMenuBar(menuBar);

        // Add ViewDataFrame for viewing data
        ViewData viewDataFrame = new ViewData(employeeController, customerController, roomController, bookingController);
        add(viewDataFrame.getContentPane(), BorderLayout.CENTER);

        pack();
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
                new Menu(employeeController, customerController, roomController, bookingController).setVisible(true);
            }
        });
    }
}
