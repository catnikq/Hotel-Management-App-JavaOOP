package io.catnikq.hotel_app.GUI;

import io.catnikq.hotel_app.inMemoryDAO.EmployeeDAO;
import io.catnikq.hotel_app.inMemoryDAO.inMemoryEmployeeDAO;
import io.catnikq.hotel_app.model.Employee;
import io.catnikq.hotel_app.controller.EmployeeController;
import io.catnikq.hotel_app.controller.EmployeeControllerImpl;
import io.catnikq.hotel_app.service.employeeService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class AddEmployee extends JFrame {
    private EmployeeController employeeController;

    private JTextField nameText;
    private JTextField addressText;
    private JTextField phoneNumberText;
    private JTextField ageText;
    private JTextField genderText;
    private JTextField positionText;
    private JTextField salaryText;
    private JButton saveButton;

    public AddEmployee(EmployeeController employeeController) {
        this.employeeController = employeeController;
        initComponents();
    }

    private void initComponents() {
        setTitle("Add Employee");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2));

        add(new JLabel("Name:"));
        nameText = new JTextField();
        add(nameText);

        add(new JLabel("Address:"));
        addressText = new JTextField();
        add(addressText);

        add(new JLabel("Phone Number:"));
        phoneNumberText = new JTextField();
        add(phoneNumberText);

        add(new JLabel("Age:"));
        ageText = new JTextField();
        add(ageText);

        add(new JLabel("Gender:"));
        genderText = new JTextField();
        add(genderText);

        add(new JLabel("Position:"));
        positionText = new JTextField();
        add(positionText);

        add(new JLabel("Salary:"));
        salaryText = new JTextField();
        add(salaryText);

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        add(saveButton);
    }

    private void saveButtonActionPerformed(ActionEvent evt) {
        Employee employee = new Employee();
        employee.setName(nameText.getText());
        employee.setAddress(addressText.getText());
        employee.setPhoneNumber(phoneNumberText.getText());
        try {
            employee.setAge(Integer.parseInt(ageText.getText()));
            employee.setSalary(Double.parseDouble(salaryText.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input format.");
            return;
        }
        employee.setGender(genderText.getText());
        employee.setPosition(positionText.getText());

        employeeController.addEmployee(employee);
        System.out.println("Employee added: " + employee);
        JOptionPane.showMessageDialog(this, "Employee added successfully!");
    }

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new inMemoryEmployeeDAO();
        employeeService employeeService = new employeeService(employeeDAO);
        EmployeeController employeeController = new EmployeeControllerImpl(employeeService);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEmployee(employeeController).setVisible(true);
            }
        });
    }
}
