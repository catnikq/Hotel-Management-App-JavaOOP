package io.catnikq.hotel_app.service;

import io.catnikq.hotel_app.inMemoryDAO.CustomerDAO;
import io.catnikq.hotel_app.model.Customer;

import java.util.List;

public class customerService {

    private CustomerDAO customerDAO;

    public customerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void addCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    public Customer getCustomerById(int customerId) {
        return customerDAO.getById(customerId);
    }

    public void updateCustomer(Customer customer) {
        customerDAO.update(customer);
    }

    public void deleteCustomer(int customerId) {
        customerDAO.delete(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAll();
    }

}
