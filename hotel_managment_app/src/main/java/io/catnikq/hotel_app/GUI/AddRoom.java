package io.catnikq.hotel_app.GUI;

import io.catnikq.hotel_app.inMemoryDAO.RoomDAO;
import io.catnikq.hotel_app.inMemoryDAO.inMemoryRoomDAO;
import io.catnikq.hotel_app.controller.RoomController;
import io.catnikq.hotel_app.controller.RoomControllerImpl;
import io.catnikq.hotel_app.model.Room;
import io.catnikq.hotel_app.service.roomService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame {

    private RoomController roomController;
    private ViewData viewData;
    
    private JTextField roomTypeText;
    private JTextField priceText;
    private JTextField roomNumberText;
    private JButton saveButton;

    public AddRoom(RoomController roomController, ViewData viewData) {
        this.roomController = roomController;
        this.viewData = viewData;
        initComponents();
    }

    private void initComponents() {
        setTitle("Add Room");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Room Type:"));
        roomTypeText = new JTextField();
        add(roomTypeText);

        add(new JLabel("Price:"));
        priceText = new JTextField();
        add(priceText);

        add(new JLabel("Room Number:"));
        roomNumberText = new JTextField();
        add(roomNumberText);

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        add(saveButton);
    }

    private void saveButtonActionPerformed(ActionEvent evt) {
        Room room = new Room();
        room.setRoomType(roomTypeText.getText());
        room.setRoomNumber(Integer.parseInt(roomNumberText.getText()));
        try {
            room.setPrice(Double.parseDouble(priceText.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price format.");
            return;
        }
        room.setStatus("Available");

        roomController.addRoom(room);
        if (viewData != null) {
            viewData.loadData();
        }
        JOptionPane.showMessageDialog(this, "Room added successfully!");
    }

    public static void main(String[] args) {
        RoomDAO roomDAO = new inMemoryRoomDAO();
        roomService roomService = new roomService(roomDAO);
        RoomController roomController = new RoomControllerImpl(roomService);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddRoom(roomController, null).setVisible(true);
            }
        });
    }
}
