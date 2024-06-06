package io.catnikq.hotel_app.service;

import io.catnikq.hotel_app.model.Customer;
import io.catnikq.hotel_app.mockData.inMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class customerService {
    public void addCustomer(Customer customer) {
        customer.setId(inMemoryDatabase.getNextPersonId());
        customer.setCustomerID(inMemoryDatabase.getNextCustomerId());
        inMemoryDatabase.customers.put(customer.getCustomerID(), customer);
        inMemoryDatabase.persons.put(customer.getId(), customer);
    }

    public Customer getCustomerById(int customerId) {
        return inMemoryDatabase.customers.get(customerId);
    }

    public void updateCustomer(Customer customer) {
        if (inMemoryDatabase.customers.containsKey(customer.getCustomerID())) {
            inMemoryDatabase.customers.put(customer.getCustomerID(), customer);
            inMemoryDatabase.persons.put(customer.getId(), customer);
        }
    }

    public void deleteCustomer(int customerId) {
        Customer customer = inMemoryDatabase.customers.remove(customerId);
        if (customer != null) {
            inMemoryDatabase.persons.remove(customer.getId());
        }
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(inMemoryDatabase.customers.values());
    }
}
