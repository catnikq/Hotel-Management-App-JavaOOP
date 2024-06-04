package io.catnikq.hotel_app;

public class Person {

    // Variables to store personal information
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private int age;
    private String gender;

    // Constructor to initialize the Person object
    public Person(int id, String name, String address, String phoneNumber, int age, String gender) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.gender = gender;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //toString
    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", age=" + age + ", gender=" + gender + '}';
    }

}
