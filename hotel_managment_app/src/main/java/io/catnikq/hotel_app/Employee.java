package io.catnikq.hotel_app;

public class Employee extends Person {
    private String employeeID;
    private String position;
    private Float salary;

    public Employee(String name, String address, String phoneNumber, Integer age, String gender) {
        super(name, address, phoneNumber, age, gender);
        this.employeeID = employeeID;
        this.position = position;
        this.salary = salary;
    }

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
