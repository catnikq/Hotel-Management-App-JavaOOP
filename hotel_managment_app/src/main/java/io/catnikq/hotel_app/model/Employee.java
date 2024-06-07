package io.catnikq.hotel_app.model;

public class Employee extends Person {

    //Employee attributes
    private int employeeID;
    private String position;
    private double salary;

    // Constructor
    public Employee(int id, int employeeID, String position, double salary, String name, String address, String phoneNumber, int age, String gender) {
        super(id, name, address, phoneNumber, age, gender);
        this.employeeID = employeeID;
        this.position = position;
        this.salary = salary;
    }

    // Default constructor
    public Employee() {

    }

    // Getters and Setters
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeID=" + employeeID
                + ", position=" + position
                + ", salary=" + salary
                + ", name='" + getName() + '\''
                + ", address='" + getAddress() + '\''
                + ", phoneNumber='" + getPhoneNumber() + '\''
                + ", age=" + getAge()
                + ", gender='" + getGender() + '\'' + '}';
    }

}
