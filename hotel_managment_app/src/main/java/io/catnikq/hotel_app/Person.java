package io.catnikq.hotel_app;

public class Person {
    // Variables to store personal information
    private String name;
    private String address;
    private String phoneNumber;
    private Integer age;
    private String gender;
    
    // Constructor to initialize the Person object
    public Person(String name, String address, String phoneNumber, Integer age, String gender) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }
    
    // Getter and Setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter methods for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter methods for phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter methods for age
    public Integer getAge() {
        return age;
    }

 
    public void setAge(Integer age) {
        this.age = age;
    }
    
    //Getter and Setter for gender
    public String getGender(){
        return gender;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
}