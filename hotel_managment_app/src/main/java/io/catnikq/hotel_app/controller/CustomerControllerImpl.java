package io.catnikq.hotel_app.controller;

import io.catnikq.hotel_app.model.Customer;
import io.catnikq.hotel_app.service.customerService;
import java.util.List;

public class CustomerControllerImpl implements CustomerController {

    private customerService customerService;

    public CustomerControllerImpl(customerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerService.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return customerService.getCustomerById(customerId);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerService.deleteCustomer(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

}
