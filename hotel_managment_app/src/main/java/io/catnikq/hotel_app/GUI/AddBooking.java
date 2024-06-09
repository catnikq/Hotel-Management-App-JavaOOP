package io.catnikq.hotel_app.GUI;

import io.catnikq.hotel_app.inMemoryDAO.BookingDAO;
import io.catnikq.hotel_app.inMemoryDAO.CustomerDAO;
import io.catnikq.hotel_app.inMemoryDAO.RoomDAO;
import io.catnikq.hotel_app.inMemoryDAO.inMemoryBookingDAO;
import io.catnikq.hotel_app.inMemoryDAO.inMemoryCustomerDAO;
import io.catnikq.hotel_app.inMemoryDAO.inMemoryRoomDAO;
import io.catnikq.hotel_app.controller.BookingController;
import io.catnikq.hotel_app.controller.BookingControllerImpl;
import io.catnikq.hotel_app.controller.CustomerController;
import io.catnikq.hotel_app.controller.CustomerControllerImpl;
import io.catnikq.hotel_app.controller.RoomController;
import io.catnikq.hotel_app.controller.RoomControllerImpl;
import io.catnikq.hotel_app.model.Booking;
import io.catnikq.hotel_app.model.Customer;
import io.catnikq.hotel_app.model.Room;
import io.catnikq.hotel_app.service.bookingService;
import io.catnikq.hotel_app.service.customerService;
import io.catnikq.hotel_app.service.roomService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddBooking extends JFrame {

    private BookingController bookingController;
    private CustomerController customerController;
    private RoomController roomController;

    private JTextField nameText;
    private JTextField addressText;
    private JTextField phoneNumberText;
    private JTextField ageText;
    private JTextField genderText;
    private JTextField roomNumberText;
    private JTextField checkInDateText;
    private JButton saveButton;

    public AddBooking(BookingController bookingController, CustomerController customerController, RoomController roomController) {
        this.bookingController = bookingController;
        this.customerController = customerController;
        this.roomController = roomController;
        initComponents();
    }

    private void initComponents() {
        setTitle("Add Booking");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9, 2));

        add(new JLabel("Customer Name:"));
        nameText = new JTextField();
        add(nameText);

        add(new JLabel("Customer Address:"));
        addressText = new JTextField();
        add(addressText);

        add(new JLabel("Customer Phone Number:"));
        phoneNumberText = new JTextField();
        add(phoneNumberText);

        add(new JLabel("Customer Age:"));
        ageText = new JTextField();
        add(ageText);

        add(new JLabel("Customer Gender:"));
        genderText = new JTextField();
        add(genderText);

        add(new JLabel("Room Number:"));
        roomNumberText = new JTextField();
        add(roomNumberText);

        add(new JLabel("Check-In Date (YYYY-MM-DD):"));
        checkInDateText = new JTextField();
        add(checkInDateText);

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        add(saveButton);
    }

    private void saveButtonActionPerformed(ActionEvent evt) {
        Customer customer = new Customer();
        customer.setName(nameText.getText());
        customer.setAddress(addressText.getText());
        customer.setPhoneNumber(phoneNumberText.getText());
        try {
            customer.setAge(Integer.parseInt(ageText.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid age format.");
            return;
        }
        customer.setGender(genderText.getText());
        customerController.addCustomer(customer);

        Room room = roomController.getRoomByNumber(Integer.parseInt(roomNumberText.getText()));
        if (room == null || !room.getStatus().equals("Available")) {
            JOptionPane.showMessageDialog(this, "Room is not available.");
            return;
        }

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setRoom(room);
        try {
            booking.setCheckInDate(new SimpleDateFormat("yyyy-MM-dd").parse(checkInDateText.getText()));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Invalid date format.");
            return;
        }

        bookingController.addBooking(booking);
        room.setStatus("Occupied");
        roomController.updateRoom(room);

        JOptionPane.showMessageDialog(this, "Booking added successfully!");
    }

    public static void main(String[] args) {
        CustomerDAO customerDAO = new inMemoryCustomerDAO();
        RoomDAO roomDAO = new inMemoryRoomDAO();
        BookingDAO bookingDAO = new inMemoryBookingDAO();

        customerService customerService = new customerService(customerDAO);
        roomService roomService = new roomService(roomDAO);
        bookingService bookingService = new bookingService(bookingDAO, roomDAO, customerDAO);

        CustomerController customerController = new CustomerControllerImpl(customerService);
        RoomController roomController = new RoomControllerImpl(roomService);
        BookingController bookingController = new BookingControllerImpl(bookingService);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddBooking(bookingController, customerController, roomController).setVisible(true);
            }
        });
    }
}
