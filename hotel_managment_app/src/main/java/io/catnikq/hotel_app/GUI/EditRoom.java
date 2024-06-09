
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

public class EditRoom extends JFrame {
    private RoomController roomController;

    private JTextField roomNumberText;
    private JTextField roomTypeText;
    private JTextField priceText;
    private JTextField statusText;
    private JButton updateButton;
    private JButton deleteButton;

    public EditRoom(RoomController roomController) {
        this.roomController = roomController;
        initComponents();
    }

    private void initComponents() {
        setTitle("Edit Room");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Room Number:"));
        roomNumberText = new JTextField();
        add(roomNumberText);

        add(new JLabel("Room Type:"));
        roomTypeText = new JTextField();
        add(roomTypeText);

        add(new JLabel("Price:"));
        priceText = new JTextField();
        add(priceText);

        // Set status, removed for logic: status is set when AddBooking and AddCheckOut
//        add(new JLabel("Status:"));
//        statusText = new JTextField();
//        add(statusText);

        updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        add(deleteButton);
    }

    private void updateButtonActionPerformed(ActionEvent evt) {
        int roomNumber = Integer.parseInt(roomNumberText.getText());
        Room room = roomController.getRoomByNumber(roomNumber);
        if (room == null) {
            JOptionPane.showMessageDialog(this, "Room not found.");
            return;
        }

        room.setRoomType(roomTypeText.getText());
        try {
            room.setPrice(Double.parseDouble(priceText.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price format.");
            return;
        }
        room.setStatus(statusText.getText());

        roomController.updateRoom(room);
        JOptionPane.showMessageDialog(this, "Room updated successfully!");
    }

    private void deleteButtonActionPerformed(ActionEvent evt) {
        int roomNumber = Integer.parseInt(roomNumberText.getText());
        roomController.deleteRoom(roomNumber);
        JOptionPane.showMessageDialog(this, "Room deleted successfully!");
    }

    public static void main(String[] args) {
        RoomDAO roomDAO = new inMemoryRoomDAO();
        roomService roomService = new roomService(roomDAO);
        RoomController roomController = new RoomControllerImpl(roomService);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditRoom(roomController).setVisible(true);
            }
        });
    }
}
