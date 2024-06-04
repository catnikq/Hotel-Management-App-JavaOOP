package io.catnikq.hotel_app;

public class Employee extends Person {
    //Employee attributes
    private String employeeID;
    private String position;
    private Float salary;
    
    //Constructor
    public Employee(int id, String employeeID, String position, Float salary, String name, String address, String phoneNumber, int age, String gender) {
        super(id, name, address, phoneNumber, age, gender);
        this.employeeID = employeeID;
        this.position = position;
        this.salary = salary;
    }
    
    //Getters and Setters
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    } 
}
