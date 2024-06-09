package io.catnikq.hotel_app.GUI;

import inMemoryDAO.BookingDAO;
import inMemoryDAO.RoomDAO;
import inMemoryDAO.inMemoryBookingDAO;
import inMemoryDAO.inMemoryRoomDAO;
import io.catnikq.hotel_app.controller.BookingController;
import io.catnikq.hotel_app.controller.BookingControllerImpl;
import io.catnikq.hotel_app.controller.RoomController;
import io.catnikq.hotel_app.controller.RoomControllerImpl;
import io.catnikq.hotel_app.model.Booking;
import io.catnikq.hotel_app.model.Room;
import io.catnikq.hotel_app.model.Service;
import io.catnikq.hotel_app.service.bookingService;
import io.catnikq.hotel_app.service.roomService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddService extends JFrame {

    private RoomController roomController;
    private BookingController bookingController;
    
    private JTextField roomNumberText;
    private JTextField serviceNameText;
    private JTextField servicePriceText;
    private JButton addServiceButton;

    public AddService(BookingController bookingController, RoomController roomController) {
        this.bookingController = bookingController;
        this.roomController = roomController;
        initComponents();
    }

    private void initComponents() {
        setTitle("Add Service");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Room Number:"));
        roomNumberText = new JTextField();
        add(roomNumberText);

        add(new JLabel("Service Name:"));
        serviceNameText = new JTextField();
        add(serviceNameText);

        add(new JLabel("Service Price:"));
        servicePriceText = new JTextField();
        add(servicePriceText);

        addServiceButton = new JButton("Add Service");
        addServiceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addServiceButtonActionPerformed(evt);
            }
        });
        add(addServiceButton);
    }

    private void addServiceButtonActionPerformed(ActionEvent evt) {
        int roomNumber = Integer.parseInt(roomNumberText.getText());
        Room room = roomController.getRoomByNumber(roomNumber);

        if (room == null || !room.getStatus().equals("Occupied")) {
            JOptionPane.showMessageDialog(this, "Room is not occupied.");
            return;
        }

        Booking booking = bookingController.getBookingByRoomNumber(roomNumber);
        if (booking == null) {
            JOptionPane.showMessageDialog(this, "No booking found for this room.");
            return;
        }

        Service service = new Service();
        service.setServiceName(serviceNameText.getText());
        service.setServicePrice(Double.parseDouble(servicePriceText.getText()));

        booking.getServices().add(service);
        booking.setTotalPrice(booking.getTotalPrice() + service.getServicePrice());
        bookingController.updateBooking(booking);

        JOptionPane.showMessageDialog(this, "Service added successfully!");
    }

    public static void main(String[] args) {
        // Initialize your controllers here
        RoomDAO roomDAO = new inMemoryRoomDAO();
        BookingDAO bookingDAO = new inMemoryBookingDAO();

        roomService roomService = new roomService(roomDAO);
        bookingService bookingService = new bookingService(bookingDAO, roomDAO, null);

        RoomController roomController = new RoomControllerImpl(roomService);
        BookingController bookingController = new BookingControllerImpl(bookingService);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddService(bookingController, roomController).setVisible(true);
            }
        });
    }
}
