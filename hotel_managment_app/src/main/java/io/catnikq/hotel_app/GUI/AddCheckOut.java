package io.catnikq.hotel_app.GUI;

import inMemoryDAO.RoomDAO;
import inMemoryDAO.inMemoryRoomDAO;
import io.catnikq.hotel_app.controller.RoomController;
import io.catnikq.hotel_app.controller.RoomControllerImpl;
import io.catnikq.hotel_app.model.Room;
import io.catnikq.hotel_app.service.roomService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCheckOut extends JFrame {

    private RoomController roomController;

    private JTextField roomNumberText;
    private JButton checkOutButton;

    public AddCheckOut(RoomController roomController) {
        this.roomController = roomController;
        initComponents();
    }

    private void initComponents() {
        setTitle("Check Out");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2));

        add(new JLabel("Room Number:"));
        roomNumberText = new JTextField();
        add(roomNumberText);

        checkOutButton = new JButton("Check Out");
        checkOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                checkOutButtonActionPerformed(evt);
            }
        });
        add(checkOutButton);
    }

    private void checkOutButtonActionPerformed(ActionEvent evt) {
        int roomNumber = Integer.parseInt(roomNumberText.getText());
        Room room = roomController.getRoomByNumber(roomNumber);

        if (room == null || !room.getStatus().equals("Occupied")) {
            JOptionPane.showMessageDialog(this, "Room is not occupied.");
            return;
        }

        room.setStatus("Available");
        roomController.updateRoom(room);
        JOptionPane.showMessageDialog(this, "Room checked out successfully!");
    }

    public static void main(String[] args) {
        RoomDAO roomDAO = new inMemoryRoomDAO();
        roomService roomService = new roomService(roomDAO);
        RoomController roomController = new RoomControllerImpl(roomService);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCheckOut(roomController).setVisible(true);
            }
        });
    }
}
