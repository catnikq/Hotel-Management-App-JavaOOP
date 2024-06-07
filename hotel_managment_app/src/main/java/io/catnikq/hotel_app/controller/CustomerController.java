package io.catnikq.hotel_app.controller;

import io.catnikq.hotel_app.model.Customer;
import java.util.List;

public interface CustomerController {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    void updateCustomer(Customer customer);

    void deleteCustomer(int customerId);

    List<Customer> getAllCustomers();
}
